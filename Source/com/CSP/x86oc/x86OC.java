package com.CSP.x86oc;

import com.CSP.x86oc.InstructionSet.ArithmeticInstructions.*;
import com.CSP.x86oc.InstructionSet.DataTransferInstructions.*;
import com.CSP.x86oc.InstructionSet.InstructionSetMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class x86OC {
    public final static ArithmeticInstructions AI = new ArithmeticInstructions();
    public final static DataTransferInstructions DTI = new DataTransferInstructions();

    public static void main(String[] args) {
        ask();
    }

    private static void ask() {
        try {
            System.out.println("Enter the instruction:");
            InputStreamReader inputStream = new InputStreamReader(System.in);
            BufferedReader inputReader = new BufferedReader(inputStream);
            String input;
            input = inputReader.readLine();
            String[] splitted = input.replaceAll("[^a-zA-Z0-9]", " ").trim().split(" ");
            String[] instructions = new String[10];
            int l = 0;
            for (int i = 0; i < splitted.length; i++) {
                if (!splitted[i].isBlank()) {
                    instructions[l] = splitted[i].toString();
                    l++;
                }
            }
            findInstructionType(instructions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void findInstructionType(String[] Instructions) {
        String[] tempInstruction = Instructions;
        String[] instructions = new String[10];
        for (int i = 0; i < tempInstruction.length; i++) {
            String tempInst = tempInstruction[i];
            if (tempInst == "") {

            } else {
                instructions[i] = (tempInst);
            }
        }
        if (instructions.length >= 0) {
            String instruction = instructions[0];
            HashMap<String, String[]> InstructionSet = InstructionSetMap.InstructionSetMap;
            String[] DTIInstructions = InstructionSet.get("DTI");
            String[] AIInstructions = InstructionSet.get("AI");
            if (indexOf(DTIInstructions, instruction) != null
                    && !DTIInstructions[indexOf(DTIInstructions, instruction)].isEmpty()) {
                DTI.findAddressingModeAndGenOpCode(instructions);
            } else if (indexOf(AIInstructions, instruction) != null
                    && !AIInstructions[indexOf(AIInstructions, instruction)].isEmpty()) {
                AI.findAddressingModeAndGenOpCode(instructions);
            } else {
            }
        } else {
            System.out.println("type ctrl+c to quit.");
        }
        ask();
    }

    private static Integer indexOf(String[] instructions, String instruction) {
        for (int k = 0; k < instructions.length; k++) {
            if (instructions[k].equalsIgnoreCase(instruction)) {
                return k;
            } else {
            }
        }
        return null;
    }
}