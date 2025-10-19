# Java CLI Menu Application

## A simple command-line Java application featuring an interactive menu system.

## Table of Contents
*   [About](#about)
*   [Features](#features)
*   [Getting Started](#getting-started)
    *   [Prerequisites](#prerequisites)
    *   [Installation](#installation)
    *   [Running the Application](#running-the-application)
*   [Usage](#usage)

### About
This repository hosts a fundamental Java Command Line Interface (CLI) application. It's structured around an interactive menu system, allowing users to navigate and interact with various features directly from the console. The `Main` class serves as the entry point, initializing the application by displaying an introductory menu.

### Features
*   **Interactive Menu System**: Engage with the application through a user-friendly, text-based menu.
*   **Modular Design**: Utilizes a dedicated `Menu` class for handling menu-related operations, promoting clean code and easy expansion.
*   **Simple Entry Point**: Easy to understand application flow starting from `Main.java`.

### Getting Started

To get a copy of this project up and running on your local machine for development and testing purposes, follow these simple steps.

#### Prerequisites
Before you begin, ensure you have the following installed:
*   Java Development Kit (JDK) 8 or higher. You can download it from [Oracle's website](https://www.oracle.com/java/technologies/downloads/).

#### Installation
1.  **Clone the repository**:
    ```bash
    git clone https://github.com/your-username/java-cli-menu-application.git
    ```
    (Replace `your-username/java-cli-menu-application.git` with the actual repository URL)
2.  **Navigate into the project directory**:
    ```bash
    cd java-cli-menu-application
    ```

#### Running the Application
1.  **Compile the Java source files**:
    Assuming `Menu.java` is also in the same directory:
    ```bash
    javac Main.java Menu.java
    ```
2.  **Execute the compiled application**:
    ```bash
    java Main
    ```

### Usage
Once the application is running, you will be greeted with an introductory message from the `Menu` class. The application will then present you with a series of options. To interact with the application:

1.  Read the prompts displayed in the console.
2.  Enter the corresponding number or character for the desired action.
3.  Press Enter to submit your choice.

Follow the on-screen instructions to navigate through the application's features. The application will guide you through its various functionalities until you choose to exit.