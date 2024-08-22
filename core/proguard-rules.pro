# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
# Koin
# Keep Koin-related classes and annotations
-keep class org.koin.core.** { *; }
-keep class org.koin.android.** { *; }
-keep class org.koin.dsl.** { *; }
-keep class org.koin.ext.** { *; }
-keep class org.koin.internal.** { *; }
-keep class org.koin.core.parameter.** { *; }
-keep class org.koin.core.scope.** { *; }
-keep class org.koin.core.qualifier.** { *; }
-keep class org.koin.core.module.** { *; }
-keep class org.koin.core.component.** { *; }
-keep class org.koin.core.context.** { *; }
-keep class org.koin.core.error.** { *; }

# Keep Koin annotations used for DI
-keep @org.koin.core.annotation.* class * { *; }

# Keep internal Koin classes used by Koin for dependency injection
-keep class org.koin.core.Koin { *; }
-keep class org.koin.core.module.Module { *; }
-keep class org.koin.core.scope.Scope { *; }

# Keep all Koin-related types for debugging and internal usage
-keep class org.koin.debug.** { *; }



# SQLCipher
-keep class net.sqlcipher.** { *; }
-dontwarn net.sqlcipher.**
-keep class net.sqlcipher.database.** { *; }



# MOSHI
# JSR 305 annotations are for embedding nullability information.
-dontwarn javax.annotation.**

-keepclasseswithmembers class * {
    @com.squareup.moshi.* <methods>;
}

-keep @com.squareup.moshi.JsonQualifier interface *

# Enum field names are used by the integrated EnumJsonAdapter.
# values() is synthesized by the Kotlin compiler and is used by EnumJsonAdapter indirectly
# Annotate enums with @JsonClass(generateAdapter = false) to use them with Moshi.
-keepclassmembers @com.squareup.moshi.JsonClass class * extends java.lang.Enum {
    <fields>;
    **[] values();
}

# Keep helper method to avoid R8 optimisation that would keep all Kotlin Metadata when unwanted
-keepclassmembers class com.squareup.moshi.internal.Util {
    private static java.lang.String getKotlinMetadataClassName();
}

# Keep ToJson/FromJson-annotated methods
-keepclassmembers class * {
  @com.squareup.moshi.FromJson <methods>;
  @com.squareup.moshi.ToJson <methods>;
}



# Retrofit does reflection on generic parameters. InnerClasses is required to use Signature and
# EnclosingMethod is required to use InnerClasses.
-keepattributes Signature, InnerClasses, EnclosingMethod

# Retrofit does reflection on method and parameter annotations.
-keepattributes RuntimeVisibleAnnotations, RuntimeVisibleParameterAnnotations

# Keep annotation default values (e.g., retrofit2.http.Field.encoded).
-keepattributes AnnotationDefault

# Retain service method parameters when optimizing.
-keepclassmembers,allowshrinking,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}

# Ignore annotation used for build tooling.
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement

# Ignore JSR 305 annotations for embedding nullability information.
-dontwarn javax.annotation.**

# Guarded by a NoClassDefFoundError try/catch and only used when on the classpath.
-dontwarn kotlin.Unit

# Top-level functions that can only be used by Kotlin.
-dontwarn retrofit2.KotlinExtensions
-dontwarn retrofit2.KotlinExtensions$*

# With R8 full mode, it sees no subtypes of Retrofit interfaces since they are created with a Proxy
# and replaces all potential values with null. Explicitly keeping the interfaces prevents this.
-if interface * { @retrofit2.http.* <methods>; }
-keep,allowobfuscation interface <1>

# Keep inherited services.
-if interface * { @retrofit2.http.* <methods>; }
-keep,allowobfuscation interface * extends <1>

# With R8 full mode generic signatures are stripped for classes that are not
# kept. Suspend functions are wrapped in continuations where the type argument
# is used.
-keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation

# R8 full mode strips generic signatures from return types if not kept.
-if interface * { @retrofit2.http.* public *** *(...); }
-keep,allowoptimization,allowshrinking,allowobfuscation class <3>

# With R8 full mode generic signatures are stripped for classes that are not kept.
-keep,allowobfuscation,allowshrinking class retrofit2.Response



# Keep the RemoteResponse class and its inner classes (Empty, Error, Loading, Success)
-keep class dev.agustacandi.learn.core.data.lib.RemoteResponse { *; }
-keep class dev.agustacandi.learn.core.data.lib.RemoteResponse$Empty { *; }
-keep class dev.agustacandi.learn.core.data.lib.RemoteResponse$Error { *; }
-keep class dev.agustacandi.learn.core.data.lib.RemoteResponse$Loading { *; }
-keep class dev.agustacandi.learn.core.data.lib.RemoteResponse$Success { *; }

# Keep the Cast model class
-keep class dev.agustacandi.learn.core.domain.credits.model.Cast { *; }

# Keep the CastRepository interface/class and its implementing classes (if any)
-keep class dev.agustacandi.learn.core.domain.credits.repository.CastRepository { *; }

# Keep the CastInteractor class
-keep class dev.agustacandi.learn.core.domain.credits.usecase.CastInteractor { *; }

# Keep the CastUseCase interface/class and its implementing classes (if any)
-keep class dev.agustacandi.learn.core.domain.credits.usecase.CastUseCase { *; }

# Keep the MovieFavoriteUseCase interface/class and its implementing classes (if any)
-keep class dev.agustacandi.learn.core.domain.favorite.usecase.MovieFavoriteUseCase { *; }

# Keep the DetailMovie model class
-keep class dev.agustacandi.learn.core.domain.movie.model.DetailMovie { *; }

# Keep the Genres model class
-keep class dev.agustacandi.learn.core.domain.movie.model.Genres { *; }

# Keep the Movie model class
-keep class dev.agustacandi.learn.core.domain.movie.model.Movie { *; }

# Keep the MovieRepository interface/class and its implementing classes (if any)
-keep class dev.agustacandi.learn.core.domain.movie.repository.MovieRepository { *; }

# Keep the MovieInteractor class
-keep class dev.agustacandi.learn.core.domain.movie.usecase.MovieInteractor { *; }

# Keep the MovieUseCase interface/class and its implementing classes (if any)
-keep class dev.agustacandi.learn.core.domain.movie.usecase.MovieUseCase { *; }

# Keep the ConstVal class and its fields/methods
-keep class dev.agustacandi.learn.core.utils.ConstVal { *; }

# Keep the Helper class and its fields/methods
-keep class dev.agustacandi.learn.core.utils.Helper { *; }

# Keep the extension functions defined in DoubleExtKt, StringExtKt, and ViewExtKt
-keep class dev.agustacandi.learn.core.utils.ext.DoubleExtKt { *; }
-keep class dev.agustacandi.learn.core.utils.ext.StringExtKt { *; }
-keep class dev.agustacandi.learn.core.utils.ext.ViewExtKt { *; }
