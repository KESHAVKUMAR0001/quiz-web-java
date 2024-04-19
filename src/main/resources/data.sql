-- Seed Questions for Java Quiz Application
INSERT INTO questions (id, title, option_a, option_b, option_c, option_d, correct_option) VALUES
(1, 'What is the size of int data type in Java?', '2 bytes', '4 bytes', '8 bytes', 'Depends on OS', 2),
(2, 'Which of the following is NOT a Java keyword?', 'static', 'Boolean', 'void', 'private', 2),
(3, 'Which concept of OOP is demonstrated by having multiple methods with the same name but different parameters?', 'Inheritance', 'Polymorphism (Overloading)', 'Encapsulation', 'Abstraction', 2),
(4, 'Which collection class allows unique elements and maintains no specific order?', 'ArrayList', 'TreeSet', 'HashSet', 'LinkedList', 3),
(5, 'What is the default value of a boolean variable in Java?', 'true', 'false', '0', 'null', 2),
(6, 'Which exception is thrown when an array is accessed with an illegal index?', 'NullPointerException', 'ArrayIndexOutOfBoundsException', 'IllegalArgumentException', 'ClassCastException', 2),
(7, 'Which keyword is used to prevent method overriding in Java?', 'final', 'static', 'abstract', 'const', 1),
(8, 'Which memory area in JVM is used to store objects created using the "new" keyword?', 'Stack Memory', 'Heap Memory', 'Method Area', 'Program Counter Register', 2),
(9, 'What is the superclass of all classes in Java?', 'java.lang.System', 'java.lang.Class', 'java.lang.Object', 'java.lang.Throwable', 3),
(10, 'Which of the following is true about String in Java?', 'Strings are mutable', 'Strings are immutable', 'String is a primitive data type', 'Strings cannot be concatenated', 2),
(11, 'Which interface must a class implement to allow its objects to be sorted using Collections.sort()?', 'Comparator', 'Comparable', 'Serializable', 'Cloneable', 2),
(12, 'Which method is called right before an object is garbage collected in classic Java?', 'delete()', 'destroy()', 'finalize()', 'clean()', 3),
(13, 'Can a constructor be marked as "private" in Java?', 'Yes, used in patterns like Singleton', 'No, constructors must be public', 'Only if the class is abstract', 'Only in Java 8 and above', 1),
(14, 'What does the "finally" block in Java try-catch-finally execute?', 'Only if an exception is caught', 'Only if no exception occurs', 'Always, whether an exception occurs or not', 'Never if return is inside try block', 3),
(15, 'Which Java feature was introduced in Java 8 for functional programming?', 'Generics', 'Lambda Expressions', 'Annotations', 'Enums', 2);