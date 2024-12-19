
# AutoMapper

**AutoMapper** is a lightweight and easy-to-use object-to-object mapping library for Java. It dynamically maps fields between objects using reflection, supporting both standard Java classes and records.

## Features

- **Automatic Mapping**: Automatically maps fields between objects with matching names.
- **Record Support**: Maps domain objects to Java records and vice versa.
- **List Mapping**: Easily map lists of objects.
- **Zero Configuration**: No annotations or configurations are required.
- **Open Contribution**: Open-source and welcoming contributions from anyone.

## Installation

Add the following dependency to your Maven `pom.xml` file:

```xml
<dependency>
    <groupId>io.github.nobeleskinder</groupId>
    <artifactId>automapper</artifactId>
    <version>1.0.0</version>
</dependency>
```

For Gradle:

```gradle
implementation 'io.github.nobeleskinder:automapper:1.0.0'
```

## Usage

### Mapping Between Classes
```java
User user = new User("Alice", 30);
UserDTO userDTO = AutoMapper.map(user, UserDTO.class);
System.out.println(userDTO);
```

### Mapping Lists
```java
List<User> users = List.of(new User("Alice", 30), new User("Bob", 25));
List<UserDTO> userDTOList = AutoMapper.mapList(users, UserDTO.class);
userDTOList.forEach(System.out::println);
```

### Mapping Records
```java
UserDTO userDTO = new UserDTO("Alice", 30);
User user = AutoMapper.map(userDTO, User.class);
System.out.println(user);
```

## Contributing

We welcome contributions from the community! To contribute:

1. Fork the repository.
2. Create a feature branch: `git checkout -b feature-name`.
3. Commit your changes: `git commit -m "Add new feature"`.
4. Push to the branch: `git push origin feature-name`.
5. Create a pull request.

Please ensure your code passes all existing tests and include new tests for added functionality.

## License

This project is licensed under the [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0).  
You are free to use, modify, and distribute this library in your projects, whether commercial or non-commercial.

## Disclaimer

This software is provided "as is", without warranty of any kind, express or implied, including but not limited to the warranties of merchantability, fitness for a particular purpose, and non-infringement. In no event shall the authors or copyright holders be liable for any claim, damages, or other liability, whether in an action of contract, tort, or otherwise, arising from, out of, or in connection with the software or the use or other dealings in the software.

Use this library at your own risk.

---

**Note**: The license is open to everyone, and contributions are welcomed from developers worldwide. Let’s build something great together!

---

## Contact

If you have any questions, suggestions, or feedback, feel free to open an issue or reach out at [nobey01@gmail.com](mailto:nobey01@gmail.com).
