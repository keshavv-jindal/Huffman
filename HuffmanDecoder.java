import java.io.*;
import java.util.*;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipEntry;
import javax.swing.*;

class HuffmanDecoder {

    public void decompress(File zipFile) throws IOException, ClassNotFoundException {
        String baseName = zipFile.getName().replace("_compressed.zip", "");
        File huffFile = new File(zipFile.getParent(), baseName + ".huff");

        // Step 1: Extract .huff file from zip
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
            ZipEntry entry = zis.getNextEntry();
            if (entry != null && entry.getName().endsWith(".huff")) {
                try (FileOutputStream fos = new FileOutputStream(huffFile)) {
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                }
            }
        }

        // Step 2: Read .huff file
        Map<Byte, String> huffmanCodes;
        int bitLength;
        byte[] compressedBytes;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(huffFile))) {
            huffmanCodes = (Map<Byte, String>) ois.readObject();
            bitLength = (int) ois.readObject();
            compressedBytes = ois.readAllBytes();
        }

        // Step 3: Reverse code map
        Map<String, Byte> reverseCodes = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            reverseCodes.put(entry.getValue(), entry.getKey());
        }

        // Step 4: Convert bitset to bits
        BitSet bitSet = BitSet.valueOf(compressedBytes);
        StringBuilder bits = new StringBuilder();
        for (int i = 0; i < bitLength; i++) {
            bits.append(bitSet.get(i) ? '1' : '0');
        }

        // Step 5: Decode bits to bytes
        List<Byte> outputBytes = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        for (int i = 0; i < bits.length(); i++) {
            current.append(bits.charAt(i));
            if (reverseCodes.containsKey(current.toString())) {
                outputBytes.add(reverseCodes.get(current.toString()));
                current.setLength(0);
            }
        }

        byte[] finalBytes = new byte[outputBytes.size()];
        for (int i = 0; i < outputBytes.size(); i++) {
            finalBytes[i] = outputBytes.get(i);
        }

        // Step 6: Ask user where to save decompressed file
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose location to save decompressed file");
        fileChooser.setSelectedFile(new File(baseName + "_decompressed"));

        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File outFile = fileChooser.getSelectedFile();
            try (FileOutputStream fos = new FileOutputStream(outFile)) {
                fos.write(finalBytes);
            }
            System.out.println("Decompressed to: " + outFile.getAbsolutePath());
        } else {
            System.out.println("Decompression cancelled by user.");
        }

        // Step 7: Cleanup
        huffFile.delete();
    }
}
