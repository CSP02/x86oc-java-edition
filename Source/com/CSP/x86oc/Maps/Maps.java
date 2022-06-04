package com.CSP.x86oc.Maps;

import java.util.HashMap;

public class Maps {
    public static final HashMap<String, Character> BinaryHexMap = new HashMap<>();
    public static final HashMap<String, String> RegisterBinaryMap = new HashMap<>();
    public static final HashMap<String, String> ModBinaryMap = new HashMap<>();
    public static final HashMap<String, String> RByMBinaryMap = new HashMap<>();
    public static final HashMap<String, String> MnemonicsToBinaryMap = new HashMap<>();

    public Maps(){
        BinaryHexMap.put("0000", '0');
        BinaryHexMap.put("0001", '1');
        BinaryHexMap.put("0010", '2');
        BinaryHexMap.put("0011", '3');
        BinaryHexMap.put("0100", '4');
        BinaryHexMap.put("0101", '5');
        BinaryHexMap.put("0110", '6');
        BinaryHexMap.put("0111", '7');
        BinaryHexMap.put("1000", '8');
        BinaryHexMap.put("1001", '9');
        BinaryHexMap.put("1010", 'A');
        BinaryHexMap.put("1011", 'B');
        BinaryHexMap.put("1100", 'C');
        BinaryHexMap.put("1101", 'D');
        BinaryHexMap.put("1110", 'E');
        BinaryHexMap.put("1111", 'F');

        RegisterBinaryMap.put("ax", "000");
        RegisterBinaryMap.put("al", "000");
        RegisterBinaryMap.put("cx", "001");
        RegisterBinaryMap.put("cl", "001");
        RegisterBinaryMap.put("dx", "010");
        RegisterBinaryMap.put("dl", "010");
        RegisterBinaryMap.put("bx", "011");
        RegisterBinaryMap.put("bl", "011");
        RegisterBinaryMap.put("ah", "100");
        RegisterBinaryMap.put("sp", "100");
        RegisterBinaryMap.put("ch", "101");
        RegisterBinaryMap.put("bp", "101");
        RegisterBinaryMap.put("dh", "110");
        RegisterBinaryMap.put("si", "110");
        RegisterBinaryMap.put("bh", "111");
        RegisterBinaryMap.put("di", "111");

        ModBinaryMap.put("16D", "10");
        ModBinaryMap.put("8D", "01");
        ModBinaryMap.put("0D", "00");
        ModBinaryMap.put("REG2REG", "11");

        RByMBinaryMap.put("BXSI", "000");
        RByMBinaryMap.put("BXDI", "001");
        RByMBinaryMap.put("BPSI", "010");
        RByMBinaryMap.put("BPDI", "011");
        RByMBinaryMap.put("SI", "100");
        RByMBinaryMap.put("DI", "101");
        RByMBinaryMap.put("D16", "110");
        RByMBinaryMap.put("BX", "111");

        MnemonicsToBinaryMap.put("XLAT", "1101 0111");
        MnemonicsToBinaryMap.put("LAHF", "1001 1111");
        MnemonicsToBinaryMap.put("SAHF", "1001 1110");
        MnemonicsToBinaryMap.put("PUSHF", "1001 1100");
        MnemonicsToBinaryMap.put("POPF", "1001 1101");
        MnemonicsToBinaryMap.put("AAA", "0011 0111");
        MnemonicsToBinaryMap.put("BAA", "0010 0111");
        MnemonicsToBinaryMap.put("NEG", "1111 011w mod01 1rbym");
        MnemonicsToBinaryMap.put("AAS", "0011 1111");
        MnemonicsToBinaryMap.put("DAS", "0010 1111");
        MnemonicsToBinaryMap.put("MUL", "1111 011w mod10 0rbym");
        MnemonicsToBinaryMap.put("IMUL", "1111 011w mod10 1rbym");
        MnemonicsToBinaryMap.put("AAM", "1101 0100 0000 1010");
        MnemonicsToBinaryMap.put("DIV", "1111 011w mod11 0rbym");
        MnemonicsToBinaryMap.put("IDIV", "1111 011w mod11 1rbym");
        MnemonicsToBinaryMap.put("AAD", "1101 0101 0000 1010");
        MnemonicsToBinaryMap.put("CBW", "1001 1000");
        MnemonicsToBinaryMap.put("CWD", "1001 1001");
        MnemonicsToBinaryMap.put("NOT", "1111 011w mod0 10rbym");
        MnemonicsToBinaryMap.put("MOVS", "1010 010w");
        MnemonicsToBinaryMap.put("CMPS", "1010 011w");
        MnemonicsToBinaryMap.put("SCAS", "1010 111w");
        MnemonicsToBinaryMap.put("LODS", "1010 110w");
        MnemonicsToBinaryMap.put("STOS", "1010 101w");
        MnemonicsToBinaryMap.put("HLT", "1111 0100");
        MnemonicsToBinaryMap.put("WAIT", "1001 1011");
    }
}