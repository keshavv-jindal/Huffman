import java.io.*;
import java.util.*;
import java.util.PriorityQueue;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

class HuffmanNode {
    byte data;
    int freq;
    HuffmanNode left, right;

    HuffmanNode(byte data, int freq) {
        this.data = data;
        this.freq = freq;
    }
}

class HuffmanEncoder {
    private Map<Byte, String> huffmanCodes = new HashMap<>();
    private HuffmanNode root;

    public void compress(File inputFile) throws IOException {
        byte[] fileBytes = Files.readAllBytes(inputFile.toPath());
        Map<Byte, Integer> freqMap = buildFrequencyMap(fileBytes);
        buildHuffmanTree(freqMap);
        buildCodes(root, "");

        StringBuilder encodedBits = new StringBuilder();
        for (byte b : fileBytes) {
            encodedBits.append(huffmanCodes.get(b));
        }

        BitSet bitSet = new BitSet(encodedBits.length());
        for (int i = 0; i < encodedBits.length(); i++) {
            if (encodedBits.charAt(i) == '1') {
                bitSet.set(i);
            }
        }

        File huffFile = new File(inputFile.getParent(), inputFile.getName().replaceAll("\\.[^.]+$", "") + ".huff");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(huffFile))) {
            oos.writeObject(huffmanCodes);
            oos.writeObject(encodedBits.length());
            oos.write(bitSet.toByteArray());
        }

        File zipFile = new File(inputFile.getParent(), inputFile.getName().replaceAll("\\.[^.]+$", "") + "_compressed.zip");
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile))) {
            zos.putNextEntry(new ZipEntry(huffFile.getName()));
            Files.copy(huffFile.toPath(), zos);
            zos.closeEntry();
        }

        huffFile.delete();
        System.out.println("Compressed to: " + zipFile.getAbsolutePath());
    }

    private Map<Byte, Integer> buildFrequencyMap(byte[] bytes) {
        Map<Byte, Integer> freqMap = new HashMap<>();
        for (byte b : bytes) {
            freqMap.put(b, freqMap.getOrDefault(b, 0) + 1);
        }
        return freqMap;
    }

    private void buildHuffmanTree(Map<Byte, Integer> freqMap) {
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.freq));
        for (Map.Entry<Byte, Integer> entry : freqMap.entrySet()) {
            pq.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            HuffmanNode merged = new HuffmanNode((byte) 0, left.freq + right.freq);
            merged.left = left;
            merged.right = right;
            pq.add(merged);
        }

        root = pq.poll();
    }

    private void buildCodes(HuffmanNode node, String code) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            huffmanCodes.put(node.data, code);
        }
        buildCodes(node.left, code + "0");
        buildCodes(node.right, code + "1");
    }
}
