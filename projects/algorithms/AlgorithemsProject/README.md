<div align="center">

<img src="https://capsule-render.vercel.app/api?type=soft&color=0:2C3E50,100:4CA1AF&height=160&section=header&text=Cocktail%20Sort&fontSize=40&fontColor=ffffff&animation=fadeIn&fontAlignY=40&desc=A%20bidirectional%20bubble%20sort%2C%20built%20from%20scratch&descAlignY=65&descSize=16" width="100%"/>

</div>

## What this is

A small console program for my Algorithms course that implements cocktail sort, also called bidirectional bubble sort, by hand. No `Arrays.sort` or `Collections.sort` anywhere: the array is sorted by repeatedly sweeping forward then backward across it, shrinking the unsorted range from both ends each pass.

## Why it exists

Regular bubble sort only ever sweeps in one direction, so a single small value stuck near the end of the array takes almost the whole run to crawl back to the front. Cocktail sort fixes that by alternating direction every pass: one sweep pushes the largest remaining value to the top, the next pushes the smallest remaining value to the bottom, and the `start`/`end` bounds close in from both sides as it goes. This project exists to actually trace through that alternating logic and the early exit condition in code, rather than just read the pseudocode.

## What it covers

| Piece | What it shows |
|---|---|
| `CocktailSort.cocktailSort` | The alternating forward/backward sweep. `start` and `end` shrink the unsorted window each pass, and a `flag` breaks out early once a full pass makes no swaps. |
| `CocktailSort.printArray` | Prints the array as a single space separated line. |
| `AlgorithemsProject` (main) | Builds a sample unsorted array, runs the sort, and prints the result. |

## Running it

**In NetBeans:** open this folder as a project and run `AlgorithemsProject.java`.

**From the terminal, with Ant:**
```bash
cd projects/algorithms/AlgorithemsProject
ant jar
java -jar dist/AlgorithemsProject.jar
```

**Or straight with the JDK, no Ant required:**
```bash
cd projects/algorithms/AlgorithemsProject
javac -d out src/algorithemsproject/*.java
java -cp out algorithemsproject.AlgorithemsProject
```

Both produce:
```
Result of The Sorted array:
0 1 2 3 4 8 9
```

## Project layout

```
AlgorithemsProject/
├── src/algorithemsproject/
│   ├── AlgorithemsProject.java   <- entry point, builds the sample array and runs the sort
│   └── CocktailSort.java          <- the cocktail sort algorithm and a print helper
├── build.xml                       <- Ant build script
└── nbproject/                      <- NetBeans project metadata
```

## Built with

Java, no external libraries.

<br/>

<div align="center">
<img src="https://capsule-render.vercel.app/api?type=waving&color=0:8E2DE2,100:4A00E0&height=80&section=footer" width="100%"/>
</div>
