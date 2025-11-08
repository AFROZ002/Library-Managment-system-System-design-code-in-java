# 📚 Library Management System (Core Java Project)

## 🧠 About Project
Ye project ek **simple Library Management System** hai jo Core Java me likha gaya hai.  
Iska main purpose hai **Book issue aur return process** ko samajhna — using **OOP concepts**  
like **Encapsulation, Association, Aggregation, and Delegation**.

Isme humne 4 main classes use ki hain:
- **Book** → represents ek single book (id, title, author, issued info)
- **Member** → represents ek library member (id, name, borrowed book list)
- **Librarian** → performs actions (issue / return)
- **Library** → central class that holds all data and business logic

---

## ⚙️ Technologies Used
- Java 17+
- OOP Concepts (Encapsulation, Aggregation, Delegation)
- Collections Framework (`HashMap`, `HashSet`)
- Console-based I/O (no database)

---

## 🧩 Class Relationships

| Class | Role |
|-------|------|
| `Library` | Manages all books and members (main controller) |
| `Book` | Stores book details and issue status |
| `Member` | Stores member info and borrowed book IDs |
| `Librarian` | Delegates requests to Library |
| `Main` | Runs the demo (execution flow) |

---

## 🧭 Flow (Step by Step)
1. Library object create hota hai (`Library library = new Library("City Library", "MG Road")`)
2. Books add ki jati hain (`library.addBook(new Book(...))`)
3. Members register hote hain (`library.registerMember(new Member(...))`)
4. Librarian object create hota hai
5. Librarian calls:
   ```java
   lib.issueBook(library, "B002", "M001");



| Question                                                 | Short Answer                                              |
| -------------------------------------------------------- | --------------------------------------------------------- |
| Why use `Map<String, Member>`?                           | To quickly find any member using their unique ID          |
| Why not store only `m.getName()`?                        | You’ll lose full member info and OOP design breaks        |
| What does `this` mean in `library.issueBook(..., this)`? | Refers to current Librarian object (for logging/auditing) |
| Does `books.get()` create new object?                    | Nope — it returns reference to existing Book in map       |
