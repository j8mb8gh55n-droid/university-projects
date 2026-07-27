<div align="center">

<img src="https://capsule-render.vercel.app/api?type=soft&color=0:2C3E50,100:4CA1AF&height=160&section=header&text=Collections%20%26%20Generics&fontSize=38&fontColor=ffffff&animation=fadeIn&fontAlignY=40&desc=Sorting%2C%20searching%2C%20and%20generic%20methods%20in%20Java&descAlignY=65&descSize=16" width="100%"/>

</div>

## What this is

A small Java program built around the `java.util.Collections` framework and generic methods. It sorts and binary searches a list of custom `Student` objects using a `Comparator`, and it defines generic `min`, `max`, and `sum` methods that work on any list of comparable elements, not just one hardcoded type.

## Why it exists

Generics look abstract until you actually write a method that has to work on a `List<Integer>` one moment and a `List<Student>` the next without being copy pasted twice. This project is that exercise: one set of methods, several different types running through them.

## What it covers

| Piece | What it shows |
|---|---|
| **Generic methods** | `min`, `max`, and `sum` use a type parameter (`<E extends Comparable<E>>`) so the same method works on integers or any other comparable type. |
| **Comparator based sorting** | `Collections.sort` orders a list of `Student` objects by id using `Comparator.comparing`. |
| **Binary search on objects** | `Collections.binarySearch` finds a `Student` by id, which only works correctly because the list is sorted with the same comparator first. |

## Running it

**In NetBeans:** open this folder as a project and run `CollectionsGenericsSearxh.java`.

**From the terminal:**
```bash
cd projects/java-collections/CollectionsGenericsSearxh
ant jar
java -jar dist/CollectionsGenericsSearxh.jar
```

It runs straight through with data already built into `main`, no input required. Expect output like:

```
id: 5, at index: 1
List 1: [5, 8, 2, 10]
Min of List 1: 2
Sum of List 1: 25
List 2: [7, 3, 9, 1]
Min of List 2: 1
Sum of List 2: 20
```

## Project layout

```
CollectionsGenericsSearxh/
├── src/javaapplication12/
│   ├── CollectionsGenericsSearxh.java   <- generic methods, sorting, binary search
│   └── Student.java                      <- the object being sorted and searched
├── build.xml                             <- Ant build script
└── nbproject/                            <- NetBeans project metadata
```

## Built with

Java and `java.util.Collections`.
