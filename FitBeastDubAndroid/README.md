# FITBEASTDUB FITNESS — Android Studio project

This is the rebuilt offline-first Android project using the supplied FITBEASTDUB branding and original dark/red visual style.

## Improvements in this version
- Native Android SharedPreferences storage, so programs and workout history persist on the device without relying only on browser localStorage.
- No INTERNET permission; the app does not need a network connection.
- Individual reps and weight logging for each set, plus add-set controls.
- Optional workout notes.
- Weekly workout and set totals.
- Existing saved workout history is migrated from the earlier single-value format when the app opens.
- Rest timer, starter Push/Pull/Legs programs, custom program builder, and supplied logo are retained.

## Build the installable APK on Windows
1. Extract this ZIP to a normal folder (do not open the ZIP directly).
2. In Android Studio choose **Open**, then select the `FitBeastDubAndroid` folder — the one containing `settings.gradle`.
3. If Android Studio asks to install Android SDK Platform 35 or a compatible Gradle version, accept the installation. Use JDK 17 in **Settings > Build, Execution, Deployment > Build Tools > Gradle > Gradle JDK**.
4. Wait for Gradle sync to finish.
5. Choose **Build > Build Bundle(s) / APK(s) > Build APK(s)**.
6. The debug APK is normally created at `app\build\outputs\apk\debug\app-debug.apk`.

## Notes
- This ZIP contains the Android Studio source project, not a precompiled APK. A working Android SDK/Gradle build environment is required to compile the APK.
- The app requests no internet permission.
