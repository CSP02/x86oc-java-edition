package com.CSP.x86oc.InstructionSet.DataTransferInstructions;

import com.CSP.x86oc.Maps.Maps;

public class MOV extends Maps {
    MOV(String source, String destination, String binarycode, String hexcode, Integer w) {
        try {
            Integer.parseInt(source.replace("h", ""));
            if (source.toString().length() >= 4 && !source.contains("h")) {
                String lowerByte = source.toString().substring(2);
                String higherByte = source.replace(lowerByte, "");
                if (lowerByte.toString().length() != 2) {
                    lowerByte = "0" + lowerByte;
                }
                if (higherByte.toString().length() != 2) {
                    higherByte = "0" + higherByte;
                }
                if (destination.matches("[a-zA-Z]+")) {
                    String mod = ModBinaryMap.get("0D");
                    String rbym = RByMBinaryMap.get("D16");
                    String reg = RegisterBinaryMap.get(destination);
                    String binary8Bit = "1000 1010 " + mod + reg.substring(0, 2) + " " + reg.substring(2) + rbym;
                    String binary16Bit = "1000 1011 " + mod + reg.substring(0, 2) + " " + reg.substring(2) + rbym;
                    hexcode = "";
                    String[] nibbles = binary8Bit.split(" ");
                    for (Integer i = 0; i < nibbles.length; i++) {
                        String binaryNibble = nibbles[i];
                        hexcode += BinaryHexMap.get(binaryNibble);
                    }
                    System.out.println(hexcode + lowerByte + higherByte + "h -> 8bit data");
                    hexcode = "";
                    String[] nibbles16 = binary16Bit.split(" ");
                    for (Integer i = 0; i < nibbles16.length; i++) {
                        String binaryNibble = nibbles16[i];
                        hexcode += BinaryHexMap.get(binaryNibble);
                    }
                    System.out.println(hexcode + lowerByte + higherByte + "h -> 16bit data");
                } else {
                    System.out.println("Invalid Instruction");
                    return;
                }
            } else {
                // immediate to register
                if (destination.matches("[a-zA-Z]+")) {
                    binarycode = "1011 " + w + RegisterBinaryMap.get(destination);
                    String[] nibbles = binarycode.split(" ");
                    for (Integer i = 0; i < nibbles.length; i++) {
                        String binaryNibble = nibbles[i];
                        hexcode += BinaryHexMap.get(binaryNibble);
                    }
                    System.out.println(hexcode + source);
                } else if (destination.length() >= 4) {// immediate to memory
                    String mod = ModBinaryMap.get("0D");
                    String rbym = RByMBinaryMap.get("D16");
                    binarycode = "1100" + " " + "011" + w + " " + mod + "00" + " " + "0" + rbym;
                    String[] nibbles = binarycode.split(" ");
                    for (Integer i = 0; i < nibbles.length; i++) {
                        String binaryNibble = nibbles[i];
                        hexcode += BinaryHexMap.get(binaryNibble);
                    }
                    System.out.println(hexcode + source);
                } else {
                    System.out.println("Invalid Instruction");
                    return;
                }
            }
        } catch (Exception e) {
            if (source.length() <= 2 && destination.length() <= 2) {// register to register
                String mod = ModBinaryMap.get("REG2REG");
                String reg = RegisterBinaryMap.get(source).substring(0, 2);
                String rbym = RegisterBinaryMap.get(source).substring(2) + RegisterBinaryMap.get(destination);
                binarycode = "1000 100" + w + " " + mod + reg + " " + rbym;
                hexcode = "";
                String[] nibbles = binarycode.split(" ");
                for (Integer i = 0; i < nibbles.length; i++) {
                    String binaryNibble = nibbles[i];
                    hexcode += BinaryHexMap.get(binaryNibble);
                }
                System.out.println(hexcode + "h");
            } else if (source.length() <= 2 && destination.length() >= 4) {// register to memory
                String lowerByte = destination.toString().substring(2);
                String higherByte = destination.replace(lowerByte, "");
                if (lowerByte.toString().length() != 2) {
                    lowerByte = "0" + lowerByte;
                }
                if (higherByte.toString().length() != 2) {
                    higherByte = "0" + higherByte;
                }
                String mod = ModBinaryMap.get("0D");
                String rbym = RegisterBinaryMap.get(source).substring(2) + RByMBinaryMap.get("D16");
                String reg = RegisterBinaryMap.get(source).substring(0, 2);
                binarycode = "1000 100" + w + " " + mod + reg + " " + rbym;
                String[] nibbles = binarycode.split(" ");
                for (Integer i = 0; i < nibbles.length; i++) {
                    String binaryNibble = nibbles[i];
                    hexcode += BinaryHexMap.get(binaryNibble);
                }
                System.out.println(hexcode + lowerByte + higherByte + "h");
            } else {
                if (w == 1) {
                    String lowerByte = source.toString().substring(2);
                    String higherByte = source.replace(lowerByte, "");
                    if (lowerByte.toString().length() != 2) {
                        lowerByte = "0" + lowerByte;
                    }
                    if (higherByte.toString().length() != 2) {
                        higherByte = "0" + higherByte;
                    }
                }
                if (destination.matches("[a-zA-Z]+")) {
                    binarycode = "1011 " + w + RegisterBinaryMap.get(destination);
                    String[] nibbles = binarycode.split(" ");
                    for (Integer i = 0; i < nibbles.length; i++) {
                        String binaryNibble = nibbles[i];
                        hexcode += BinaryHexMap.get(binaryNibble);
                    }
                    System.out.println(hexcode + source);
                } else if (destination.length() >= 4) {
                    // immediate to memory
                    String mod = ModBinaryMap.get("0D");
                    String rbym = RByMBinaryMap.get("D16");
                    binarycode = "1100 011" + w + " " + mod + "00 0" + rbym;
                    String[] nibbles = binarycode.split(" ");
                    for (Integer i = 0; i < nibbles.length; i++) {
                        String binaryNibble = nibbles[i];
                        hexcode += BinaryHexMap.get(binaryNibble);
                    }
                    System.out.println(hexcode + source);
                }
            }
        }
    }
}