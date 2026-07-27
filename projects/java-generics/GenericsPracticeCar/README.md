<div align="center">

<img src="https://capsule-render.vercel.app/api?type=soft&color=0:2C3E50,100:4CA1AF&height=160&section=header&text=Generics%20Practice&fontSize=38&fontColor=ffffff&animation=fadeIn&fontAlignY=40&desc=A%20generic%20stack%20and%20a%20generic%20print%20method&descAlignY=65&descSize=16" width="100%"/>

</div>

## What this is

A small Java program built to practice writing code that works on more than one type at once. It defines a generic `GenericStack<E>` that can hold `Student` objects or `Car` objects with the exact same class, and a generic `printArray` method that prints any array, whatever type it's made of.

## Why it exists

The point of generics is writing a class or method once and reusing it for whatever type shows up later, instead of writing a `StudentStack` and then a near identical `CarStack`. This project pushes both `Student` and `Car` through the same stack and the same print method to prove that one implementation really does cover both.

## What it covers

| Piece | What it shows |
|---|---|
| **Generic class** | `GenericStack<E>` wraps a `List<E>` with `push`, `pop`, and `getSize`, and works unchanged for `GenericStack<Student>` and `GenericStack<Car>`. |
| **Generic method** | `printArray(E[] array)` loops over any array type and prints each element using its own `toString`. |
| **Two unrelated types, one codebase** | `Student` and `Car` share nothing in common except being objects, and both flow through the same generic stack and print method. |

## Running it

**In NetBeans:** open this folder as a project and run `GenericsPracticeCar.java`.

**From the terminal:**
```bash
cd projects/java-generics/GenericsPracticeCar
ant jar
java -jar dist/GenericsPracticeCar.jar
```

It runs straight through with data already built into `main`, no input required. Expect:

```
GenericStack{list=[Student{name=N, id=1}, Student{name=M, id=2}, Student{name=k, id=6}]}
GenericStack{list=[Car{modelName=benz, year=2025}, Car{modelName=benz, year=2024}, Car{modelName=benz, year=2026}]}
Student{name=N, id=1}
Student{name=k, id=6}
Car{modelName=benz, year=2025}
Car{modelName=benz, year=2024}
```

## Project layout

```
GenericsPracticeCar/
├── src/javaapplication13/
│   ├── GenericsPracticeCar.java   <- entry point, builds and prints stacks and arrays
│   ├── GenericStack.java          <- the generic stack class
│   ├── Student.java                <- one of the two types pushed through the stack
│   └── Car.java                    <- the other type pushed through the stack
├── build.xml                       <- Ant build script
└── nbproject/                      <- NetBeans project metadata
```

## Built with

Java, plain and simple.
