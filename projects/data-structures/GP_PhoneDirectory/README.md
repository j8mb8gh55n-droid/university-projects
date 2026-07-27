<div align="center">

<img src="https://capsule-render.vercel.app/api?type=soft&color=0:2C3E50,100:4CA1AF&height=160&section=header&text=Phone%20Directory&fontSize=40&fontColor=ffffff&animation=fadeIn&fontAlignY=40&desc=A%20contact%20book%20built%20on%20a%20linked%20list%20and%20a%20stack&descAlignY=65&descSize=16" width="100%"/>

</div>

## What this is

A console based contact directory for my Data Structures course. There is no database and no built in `ArrayList` doing the heavy lifting: contacts live in a custom singly linked list I wrote by hand, kept sorted as you insert, and every search you make gets pushed onto a custom stack so the directory can tell you what you searched for most.

## Why it exists

This project is where linked lists and stacks stop being diagram exercises and start doing real work. Adding a contact means walking the list to find its sorted position. Searching by name means traversing the list without losing your place. Tracking search history means a stack that remembers what you looked up and how often. Every core data structure operation gets used for something the program actually needs, not just for practice.

## What it covers

| Piece | What it shows |
|---|---|
| **Custom singly linked list** | `ContactsSinglyLinkedList<E>` handles insertion in sorted order, removal from either end, duplicate detection, and search by first letter or region, all without `java.util.LinkedList`. |
| **Custom stack** | `ContactsLLStack<E>` tracks every contact you search for, and can report the most searched contact and how many times a number came up. |
| **Interfaces and inheritance** | `Lookable` defines the search contract, `Contacts` is the shared base for `CPersonal` and `CBusiness`, each with its own fields and its own `toString`. |
| **Menu driven CLI** | Add, delete, search (by name, number, first letter, or region), view search history, and view directory statistics, all from a single running program. |

## Two versions, one bug hunt

This folder started life as two near identical projects side by side, `PhoneDirectory` and `GP_PhoneDirectory`, and it wasn't obvious which one actually worked. Testing both against the same sample contact turned up the difference fast: `PhoneDirectory` created a second, empty directory object just for searching, so every single search silently failed against data that was never there. `GP_PhoneDirectory` searched against the same directory it inserted into, so this is the version that made it here. On top of that, two smaller bugs surfaced during testing and got fixed:

- Viewing search statistics used to print "GOODBYE" and quietly loop back to the menu instead of exiting, because the exit option had no `break` above it.
- The "searched personal/business contacts" stats printed a flat count of everything in the whole directory instead of what was actually searched, and the list built to show them was thrown away unused. Both are wired up properly now.

## Running it

**In NetBeans:** open this folder as a project and run `GP_PhoneDirectory.java`.

**From the terminal:**
```bash
cd projects/data-structures/GP_PhoneDirectory
ant jar
java -jar dist/GP_PhoneDirectory.jar
```

The directory starts pre-loaded with a handful of sample contacts so you can search right away without adding anything first. From the main menu you can add, delete, search, view search history, and check search statistics.

## Project layout

```
GP_PhoneDirectory/
├── src/gp_phonedirectory/
│   ├── GP_PhoneDirectory.java          <- entry point, main menu
│   ├── PhDirectory.java                 <- add, delete, search, and stats logic
│   ├── ContactsSinglyLinkedList.java     <- the hand built linked list
│   ├── ContactsLLStack.java              <- the hand built stack for search history
│   ├── Contacts.java                     <- shared base for contact types
│   ├── CPersonal.java / CBusiness.java   <- the two contact types
│   ├── Address.java                      <- business address value object
│   └── Lookable.java                     <- the search contract interface
├── build.xml                             <- Ant build script
└── nbproject/                            <- NetBeans project metadata
```

## Built with

Java, a linked list, and a stack, no external libraries.
