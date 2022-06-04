package com.CSP.x86oc.InstructionSet.DataTransferInstructions;

public class DataTransferInstructions {
    public void findAddressingModeAndGenOpCode(String[] instructions) {
        final String opcode = instructions[0];
        final String destination = instructions[1];
        final String source = instructions[2];
        final String binarycode = "";
        final String hexCode = "";
        Integer w = 0;
        if (source.length() >= 4 && destination.length() >= 4 && !source.contains("h")) {
            System.out.println("Invalid instruction you cannot send data to memory from memory");
            return;
        }
        if (source.contains("x") || (source.contains("h") && source.length() > 2)) {
            w = 1;
        } else {
            w = 0;
        }
        switch (opcode) {
            case "mov":
                new MOV(source, destination, binarycode, hexCode, w);
                break;
            default:
                System.out.println("default");
                break;
        }
    }
}