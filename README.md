# 👨‍🎓 Student Management Systeem

Een student management systeem gemaakt met Java als schoolproject SDE. Het (simpele) console programma wat wij gemaakt hebben biedt functionaliteiten zoals het toevoegen, verwijderen, bijwerken, opvragen en weergeven van studenten.
Het programma bied verschillende design patterns zoals een creationeel ontwerppatroon, een structureel ontwerppatroon, en een gedragsontwerppatroon. Hieronder staat beschreven wat er allemaal met de applicatie gedaan kan worden in de console + verdere informatie over de ontwerppatronen.

Ps. Zie de [activiteiten](https://github.com/AlexLamper/SDE/activity) van deze repo. (Via de commits is het niet duidelijk te zien vanwege het verwijderen van branches.)

## 🛠️ Functionaliteiten

- Voeg nieuwe studenten toe met hun gegevens (naam, schoolnaam, adres, leeftijd en leerjaar).
- Verwijder studenten op basis van hun naam.
- Haal informatie van een student op via zijn of haar naam.
- Werk de gegevens van een student bij.
- Toon alle studenten in het systeem.
- Genereer willekeurige studenten voor testdoeleinden.

## 📚 Ontwerppatronen

Dit programma bevat meerdere ontwerppatronen, zoals hieronder beschreven:

### Creationele Ontwerppatroon

1. **Singleton Pattern**
   - **Waar:** `StudentManager`-klasse.
   - **Doel:** Zorgt ervoor dat er slechts één instantie van `StudentManager` in de applicatie is.
   - **Code:** 
     ```java
     private static StudentManager instance;
     public static StudentManager getInstance() {
         if (instance == null) {
             instance = new StudentManager();
         }
         return instance;
     }
     ```

2. **Factory Pattern**
   - **Waar:** `StudentFactory`-klasse.
   - **Doel:** Biedt een gecentraliseerde manier om `Student`-objecten aan te maken en kapselt de instantielogica in.
   - **Code:**
     ```java
     public static Student createStudent(String name, String schoolName, String address, int age, int year) {
         return new Student(name, schoolName, address, age, year);
     }
     ```

### Structurele Ontwerppatronen

1. **Facade Pattern**
   - **Waar:** `StudentManager`-klasse.
   - **Doel:** Vereenvoudigt het beheer van studenten door een uniforme interface te bieden voor operaties zoals toevoegen, verwijderen, bijwerken en opvragen.
   - **Code Voorbeeld:** Methoden in `StudentManager`, zoals `addStudent`, `removeStudent`, `getStudent` en `getAllStudents`, functioneren als een facade.

2. **Composite Pattern**
   - **Waar:** `StudentManager` beheert een lijst van `Student`-objecten.
   - **Doel:** Behandelt individuele `Student`-objecten en collecties van `Student`-objecten op een uniforme manier via een enkele interface (`List<Student>`).
   - **Code Voorbeeld:** Operaties zoals `getAllStudents()` retourneren een uniforme collectie van `Student`-objecten.

### Gedragsontwerppatronen

1. **Iterator Pattern**
   - **Waar:** Het weergeven van alle studenten.
   - **Doel:** Biedt een standaard manier om door de lijst van studenten te itereren.
   - **Code Voorbeeld:** 
     ```java
     for (Student s : manager.getAllStudents()) {
         System.out.println(s);
     }
     ```

2. **Observer Pattern**
   - **Waar:** `StudentManager` en `Logger`-klasse.
   - **Doel:** Zorgt ervoor dat observers automatisch op de hoogte worden gebracht van wijzigingen zoals het toevoegen, verwijderen of bijwerken van studenten.
   - **Code Voorbeeld:**
     ```java
     public void notifyObservers(String message) {
         for (StudentObserver observer : observers) {
             observer.update(message);
         }
     }
     ```

## 🤝 Hoe hebben wij samengewerkt?

Beiden hebben we onze taken opgedeeld zodat we ongeveer evenveel werk zouden hebben aan dit project. Zo heeft Daniel de basisstructuur gemaakt waarbij Alex voornamelijk de design patterns en manager gemaakt heeft.
We hebben gecommuniceert door samen te bellen en de code gezamelijk na te lopen.
