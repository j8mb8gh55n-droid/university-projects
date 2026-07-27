<div align="center">

<img src="https://capsule-render.vercel.app/api?type=soft&color=0:2C3E50,100:4CA1AF&height=160&section=header&text=Clinic%20Appointments&fontSize=36&fontColor=ffffff&animation=fadeIn&fontAlignY=40&desc=8086%20assembly%2C%20straight%20to%20the%20interrupt%20vector&descAlignY=65&descSize=16" width="100%"/>

</div>

## What this is

A menu driven clinic booking system written directly in 8086 assembly for DOS, built for my Assembly Language course as a group project. There is no operating system abstraction here, every line of text on screen is a DOS interrupt call, every keystroke is read one character at a time, and every number printed is converted from binary to decimal by hand.

## Why it exists

Higher level languages hide how a program actually talks to the screen and keyboard. This project doesn't get that luxury. Printing a menu means loading a segment register, pointing DX at a string, and calling `int 21h`. Reading a choice means the same interrupt with a different function number in AH. Even printing something as simple as a three digit price needed a hand written routine that repeatedly divides by ten and pushes the remainders onto a stack to reverse their order. It is a close look at what "printing a number" costs when nothing is done for you.

## What it does

A patient facing menu with four options:

1. **Doctor information**, a list of doctors, their locations, and their working hours.
2. **Book an appointment**, choose from six available slots across three doctors, each at a different price.
3. **Your total**, asks whether you're a student and applies a 40% discount to the booked price if so, showing the price before and after.
4. **Quit**, prints a goodbye message and exits.

## Running it

This is 16-bit real mode DOS code (`.model small`, `int 21h`), so it needs a DOS environment or a compatible assembler and emulator, it will not run natively on a modern OS.

**With DOSBox and a MASM/TASM compatible assembler (such as the open source JWasm):**
```bash
jwasm -mz projectCO-lastCopy.asm
```
This produces a DOS `.exe` that runs under DOSBox or any 8086 real mode emulator.

## A bug that kept it from running at all

While testing this, the file failed to assemble entirely, on this line:

```asm
GOODBYEMSG db ,"---GOODBYE-- $"
```

A stray leading comma before the string meant the assembler had nothing before it to parse, so it rejected the file outright before ever reaching the menu logic. Removing the comma was the fix. Once that was in place, the assembled program was tested end to end through an emulator, doctor info, every appointment booking, both the student and non-student discount paths, invalid menu input, and exit, and all of it produced the correct output including the discount math (a 350 SAR appointment correctly comes out to 210 SAR after the 40% student discount).

## Project layout

```
ClinicAppointmentsSystem/
└── projectCO-lastCopy.asm   <- the entire program, menu, booking, pricing, and the digit-printing routine
```

## Built with

x86 assembly (MASM/TASM syntax) and the DOS `int 21h` API, no compiler, no runtime.
