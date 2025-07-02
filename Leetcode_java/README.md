To run `Main.java` in Visual Studio Code (VS Code), follow these steps:

---

### ✅ **Step 1: Prerequisites**

Make sure you have the following installed:

* **Java JDK** (Java 17+ recommended)
  You can check with:
  ```bash
  java -version
  ```
* **VS Code Extensions**:
  * [Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
    (Includes Language Support for Java(TM), Debugger, etc.)

---

### ✅ **Step 2: Open Your Project**

1. Open the folder containing `Main.java` in VS Code:
   * `File > Open Folder` → select the folder
2. Make sure your file is named exactly: `Main.java`

---

### ✅ **Step 3: Run the Code**

#### Option 1: Using Code Lens

* At the top of `Main.java`, click the **"Run"** or **"Run | Debug"** button that appears above the `main` method.

#### Option 2: Using Right-click

* Right-click inside the `Main.java` file → click **“Run Java”**

#### Option 3: Using Terminal

1. Open the terminal in VS Code (`Ctrl + ` or View → Terminal)
2. Compile and run manually:
   ```bash
   javac Main.java
   java Main
   ```

---

### ✅ **Sample `Main.java`**

Make sure your code looks like this structure:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }
}
```

---

### 🔁 Optional: If `Main` is in a package

If your file has:

```java
package myapp;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
```

Compile with:

```bash
javac myapp/Main.java
java myapp.Main
```

---

Let me know if you’re getting any errors or using Maven or Gradle — I can tailor instructions for that.
