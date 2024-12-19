# Keep public classes and their public and protected fields and methods.
-keep public class * {
    public protected *;
}


# Keep classes that implement Serializable, along with their fields and methods
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    !static !transient <fields>;
    private <methods>;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# Keep names of classes used in the Java Native Interface (JNI)
-keepclasseswithmembernames class * {
    native <methods>;
}

# Keep enum classes and their methods
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Keep classes and members being accessed through reflection
-keepclassmembers class * {
    public <init>(...);
}

# Avoid removing constructors that take parameters and might be used only via reflection
-keepclasseswithmembers class * {
    public <init>(...);
}
# Keep public classes and their public and protected fields and methods.
-keep public class * {
    public protected *;
}


# Keep classes that implement Serializable, along with their fields and methods
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    !static !transient <fields>;
    private <methods>;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# Keep names of classes used in the Java Native Interface (JNI)
-keepclasseswithmembernames class * {
    native <methods>;
}

# Keep enum classes and their methods
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Keep classes and members being accessed through reflection
-keepclassmembers class * {
    public <init>(...);
}

# Avoid removing constructors that take parameters and might be used only via reflection
-keepclasseswithmembers class * {
    public <init>(...);
}


# Remove logging calls before releasing the app
-assumenosideeffects class android.util.Log {
    public static *** v(...);
    public static *** d(...);
    public static *** i(...);
    public static *** w(...);
    public static *** e(...);
}

# Avoid obfuscating synthetic classes, which are often used by Java compilers to implement features like nested classes, lambdas, etc.
-keep class *$* { *; }

# Preserve all native method classes and their methods
-keepclasseswithmembernames class * {
    native <methods>;
}

# Preserve line numbers for debugging stack traces
-keepattributes LineNumberTable, SourceFile


# Remove logging calls before releasing the app
-assumenosideeffects class android.util.Log {
    public static *** v(...);
    public static *** d(...);
    public static *** i(...);
    public static *** w(...);
    public static *** e(...);
}

# Avoid obfuscating synthetic classes, which are often used by Java compilers to implement features like nested classes, lambdas, etc.
-keep class *$* { *; }

# Preserve all native method classes and their methods
-keepclasseswithmembernames class * {
    native <methods>;
}

# Preserve line numbers for debugging stack traces
-keepattributes LineNumberTable, SourceFile
