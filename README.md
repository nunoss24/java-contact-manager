# Contact Manager

A simple **Java console application** for managing contacts.  
This project allows users to create, list, search, delete, and export contacts to CSV files.  
It was built as a learning project to practice Java fundamentals and clean code structure.

---

## 📂 Project Structure
- **app** → Entry point for the application (`ContactManager.java`)  
- **commands** → Classes implementing different user commands (add, delete, search, export, list)  
- **io** → Input/output helpers  
- **models** → Data models (e.g., Contact)  
- **persistence** → Classes for file handling and storage  
- **repositories** → In-memory repositories for storing contacts  
- **services** → Services like CSV exporting and utilities  
- **export.csv** → Example of an exported contacts file  

---

## ⚡ Features
- Add new contacts  
- Delete existing contacts  
- List all saved contacts  
- Search contacts by name  
- Export contacts to CSV  

---

## 🛠️ Technologies
- **Java 17+** (or compatible version)  
- Standard libraries only (no external dependencies)  
