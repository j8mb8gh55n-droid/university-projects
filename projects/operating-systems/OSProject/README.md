<div align="center">

<img src="https://capsule-render.vercel.app/api?type=soft&color=0:2C3E50,100:4CA1AF&height=160&section=header&text=OSProject&fontSize=42&fontColor=ffffff&animation=fadeIn&fontAlignY=40&desc=Disk%20Scheduling%20%2B%20Page%20Replacement%2C%20from%20scratch&descAlignY=65&descSize=16" width="100%"/>

</div>

## What this is

A console based Java program built for my Operating Systems course. It simulates two of the core problems an OS has to solve constantly: **which disk request to serve next**, and **which page to kick out of memory when it's full**. Instead of just reading about these algorithms, this project runs them on data you provide and shows exactly how each one makes its decisions, step by step.

No frameworks, no libraries beyond the JDK. Just the logic, laid bare.

## Why it exists

Reading that SSTF picks the closest request or that LRU evicts the least recently used page is one thing. Watching the head move across the disk, or watching a page get evicted right before it was needed again, is what actually makes the concept stick. This project turns three weeks of lecture slides into something you can poke at.

## The algorithms

### Disk Scheduling
Given a set of pending disk requests, a starting head position, and a total number of cylinders, the program works out the order in which to serve those requests and the total seek distance that order costs.

| Algorithm | Strategy |
|---|---|
| **FCFS** | Serve requests in the exact order they arrived. Simple, but ignores where the head already is. |
| **SSTF** | Always jump to whichever pending request is physically closest to the current head position. |
| **SCAN** | Sweep across the disk in one direction, picking up every request along the way, then reverse. |

### Page Replacement
Given a fixed number of memory frames and a sequence of page requests, the program tracks which pages are in memory, counts faults, and decides what to evict when a new page needs a spot that's already full.

| Algorithm | Strategy |
|---|---|
| **FIFO** | Evict whichever page has been in memory the longest, regardless of how recently it was used. |
| **Optimal** | Evict the page that won't be needed again for the longest stretch of future requests. |
| **LRU** | Evict the page that hasn't been touched in the longest time. |

## Running it

**In NetBeans:** open this folder as a project and run `OSProject.java`.

**From the terminal:**
```bash
cd projects/operating-systems/OSProject
ant jar
java -jar dist/OSProject.jar
```

You'll land on a menu:
```
--- ALGORITHM CHOICES MENU ---
	1. Page Replacement
	2. Disk Scheduling
	0. Exit Program
>
```

From there:
- **Disk Scheduling** asks for total cylinders, the current head position, and 15 space separated requests, then walks through FCFS, SSTF, or SCAN and prints the seek sequence plus total seek distance.
- **Page Replacement** asks for a frame count and 20 space separated page numbers, then runs FIFO, Optimal, or LRU and prints a fault by fault trace of what's in memory at each step.

## Project layout

```
OSProject/
├── src/osproject/
│   ├── OSProject.java                 <- entry point, main menu
│   ├── DiskSchedulingAlgorithm.java    <- FCFS, SSTF, SCAN
│   └── PageReplacementAlgorithm.java   <- FIFO, Optimal, LRU
├── build.xml                          <- Ant build script
└── nbproject/                         <- NetBeans project metadata
```

## Built with

Java, a terminal, and a whiteboard full of disk head diagrams.
