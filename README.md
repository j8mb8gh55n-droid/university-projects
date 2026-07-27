<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:4A00E0,100:8E2DE2&height=220&section=header&text=University%20Projects&fontSize=48&fontColor=ffffff&animation=fadeIn&fontAlignY=35&desc=A%20growing%20archive%20of%20coursework%2C%20labs%2C%20and%20side%20quests&descAlignY=55&descSize=18" width="100%"/>

<a href="https://github.com/j8mb8gh55n-droid/university-projects">
<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&size=20&pause=1200&color=8E2DE2&center=true&vCenter=true&width=650&lines=Operating+systems+today...;Data+structures+tomorrow;Every+course%2C+one+shelf;Built+one+assignment+at+a+time" alt="Typing SVG" />
</a>

</div>

<br/>

This is where my university work lives after it leaves the classroom. Every course tends to produce its own pile of NetBeans folders, half finished experiments, and last minute submissions. This repo is the cleaned up version of that pile: real projects, organized by course, with a short explanation of what each one actually does and why it exists.

Nothing here is a tutorial copy paste. Each project started as an assignment brief and turned into something I had to reason through myself, bugs included.

<br/>

## What's inside

| Course | Project | What it does | Language |
|---|---|---|---|
| Operating Systems | [OSProject](projects/operating-systems/OSProject) | Simulates disk scheduling (FCFS, SSTF, SCAN) and page replacement (FIFO, Optimal, LRU) algorithms from the inside | Java |
| Java Collections & Generics | [CollectionsGenericsSearxh](projects/java-collections/CollectionsGenericsSearxh) | Sorts and binary searches custom objects with a Comparator, plus generic min/max/sum methods | Java |
| Java Generics | [GenericsPracticeCar](projects/java-generics/GenericsPracticeCar) | One generic stack and one generic print method, reused across two unrelated object types | Java |
| Data Structures | [GP_PhoneDirectory](projects/data-structures/GP_PhoneDirectory) | A contact directory built on a hand written linked list and stack, with sorted insertion and search history tracking | Java |

More rows get added here as new courses and projects come in. This table is the map: pick a course, follow the link, read that project's own README for the full story.

<br/>

## How it's organized

```
university-projects/
└── projects/
    ├── operating-systems/
    │   └── OSProject/
    │       ├── README.md        <- what this specific project is and how to run it
    │       ├── src/              <- the actual source code
    │       ├── build.xml         <- Ant build script (NetBeans generated)
    │       └── nbproject/        <- NetBeans project metadata
    ├── java-collections/
    │   └── CollectionsGenericsSearxh/
    │       ├── README.md
    │       ├── src/
    │       ├── build.xml
    │       └── nbproject/
    ├── java-generics/
    │   └── GenericsPracticeCar/
    │       ├── README.md
    │       ├── src/
    │       ├── build.xml
    │       └── nbproject/
    └── data-structures/
        └── GP_PhoneDirectory/
            ├── README.md
            ├── src/
            ├── build.xml
            └── nbproject/
```

Each course gets its own folder under `projects/`, and each project inside that folder is self contained with its own README. Nothing depends on anything outside its own folder, so you can clone the whole repo or just grab one project.

<br/>

## Running a project

Every project is a standard NetBeans/Ant Java project, so you have two options:

**Open it in NetBeans**
Open the project folder directly (File > Open Project) and hit run.

**Or use the command line**
```bash
cd projects/operating-systems/OSProject
ant jar
java -jar dist/OSProject.jar
```

Project specific instructions and details live in each project's own README.

<br/>

## A note on the mess

University coursework rarely comes out clean the first time. Some of these projects were written in a hurry the night before a deadline, others were revisited and refactored after the fact once the concept actually clicked. Both versions are welcome here. The point of this repo is to track how the thinking developed, not to pretend everything was perfect from the start.

<br/>

## License

MIT. See [LICENSE](LICENSE). Use it, learn from it, adapt it for your own coursework, just don't turn in the exact same code as your own.

<br/>

<div align="center">
<img src="https://capsule-render.vercel.app/api?type=waving&color=0:8E2DE2,100:4A00E0&height=120&section=footer" width="100%"/>
</div>
