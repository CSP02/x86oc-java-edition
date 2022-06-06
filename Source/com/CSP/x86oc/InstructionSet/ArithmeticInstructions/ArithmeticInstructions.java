package com.CSP.x86oc.InstructionSet.ArithmeticInstructions;

public class ArithmeticInstructions {
    public void findAddressingModeAndGenOpCode(String[] instructions) {
        String opcode = instructions[0];
        String destination = instructions[1];
        String source = instructions[2];
        String binarycode = "";
        String hexCode = "";
        int w = 0;
        try {
            if (source.length() >= 4 && destination.length() >= 4 && !source.contains("h")) {
                System.out.println("Invalid instruction you cannot send data to memory from memory");
                return;
            }
            if (opcode != "mul" && opcode != "div" && opcode != "imul" && opcode != "idiv") {
                if (source.contains("x") || (source.contains("h") && source.length() > 2)) {
                    w = 1;
                } else {
                    w = 0;
                }
            } else {
                if (destination.contains("x") || (destination.contains("h") && destination.length() > 2)) {
                    w = 1;
                } else {
                    w = 0;
                }
            }
            switch (opcode) {
                case "mul":
                    new MUL(source, destination, binarycode, hexCode, w);
                    break;
                case "div":
                    new DIV(source, destination, binarycode, hexCode, w);
                    break;
                default:
                    System.out.println("default");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Invalid Instruction");
            return;
        }
    }
}