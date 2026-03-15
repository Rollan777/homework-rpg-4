# Quick Start Guide

## Prerequisites
- Java 17 or higher
- Any Java IDE (IntelliJ IDEA, VS Code, Eclipse)

## Setup
1. Open `homework-4` in your IDE.
2. Mark `src` as Sources Root if required.
3. Read files in this order:
   - `README.md`
   - `ASSIGNMENT.md`
   - `src/com/narxoz/rpg/hints/COMPOSITE_HINTS.md`
   - `src/com/narxoz/rpg/hints/BRIDGE_HINTS.md`

## Compile and Run
```bash
cd homework-4
javac -d out $(find src -name "*.java")
java -cp out com.narxoz.rpg.Main
```

Windows PowerShell alternative:
```powershell
cd homework-4
javac -d out (Get-ChildItem -Recurse -Filter *.java src | ForEach-Object { $_.FullName })
java -cp out com.narxoz.rpg.Main
```

## Recommended Implementation Order
1. Complete Composite interfaces and leaf classes.
2. Complete Composite group classes and tree printing.
3. Complete Bridge implementors and skill classes.
4. Integrate all parts in `RaidEngine`.
5. Finalize `Main.java` demo.

## Success Criteria
- Project compiles without errors.
- Main demo shows Bridge and Composite explicitly.
- Battle output is readable and deterministic with fixed seed.
