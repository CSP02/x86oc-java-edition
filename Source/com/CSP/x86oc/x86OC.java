package com.CSP.x86oc;

import com.CSP.x86oc.InstructionSet.ArithmeticInstructions.*;
import com.CSP.x86oc.InstructionSet.DataTransferInstructions.*;
import com.CSP.x86oc.InstructionSet.InstructionSetMap;

import java.util.HashMap;
import java.util.Scanner;

public class x86OC {
    public final static ArithmeticInstructions AI = new ArithmeticInstructions();
    public final static DataTransferInstructions DTI = new DataTransferInstructions();

    public static void main(String[] args) {
        ask();
    }

    private static void ask() {
        System.out.println("Enter the instruction:");
        try (Scanner inputScanner = new Scanner(System.in)) {
            String input = inputScanner.nextLine();
            String[] splitted = input.replaceAll("[^a-zA-Z0-9]", " ").trim().split(" ");
            String[] instruction = new String[10];
            Integer l = 0;
            for (Integer i = 0; i < splitted.length; i++) {
                if (!splitted[i].isBlank()) {
                    instruction[l] = splitted[i].toString();
                    l++;
                    // System.out.println(instruction[i]);
                }
            }
            findInstructionType(instruction);
        }
    }

    private static void findInstructionType(String[] Instructions) {
        String[] tempInstruction = Instructions;
        String[] instructions = new String[10];
        for (Integer i = 0; i < tempInstruction.length; i++) {
            String tempInst = tempInstruction[i];
            if (tempInst == "") {

            } else {
                instructions[i] = (tempInst);
            }
        }
        if (instructions.length >= 0) {
            String instruction = instructions[0];
            InstructionSetMap instructionSetMap = new InstructionSetMap();
            HashMap<String, String[]> InstructionSet = instructionSetMap.InstructionSetMap;
            String[] DTIInstructions = InstructionSet.get("DTI");
            String[] AIInstructions = InstructionSet.get("AI");
            if (!DTIInstructions[indexOf(DTIInstructions, instruction)].isEmpty()) {
                DTI.findAddressingModeAndGenOpCode(instructions);
            } else if (!AIInstructions[indexOf(AIInstructions, instruction)].isEmpty()) {
                AI.findAddressingModeAndGenOpCode(instructions);
            } else {
            }
        } else {
            System.out.println("type ctrl+c to quit.");
        }
        ask();
    }

    private static Integer indexOf(String[] instructions, String instruction) {
        for (Integer k = 0; k < instructions.length; k++) {
            if (instructions[k].equalsIgnoreCase(instruction)) {
                return k;
            } else {
            }
        }
        return null;
    }
}