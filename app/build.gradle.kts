// Merge/apply one of the following snippets into the existing android { ... } block in app/build.gradle.
// If your app uses Groovy build.gradle use the first block.
// If your app uses Kotlin DSL (build.gradle.kts) convert accordingly (example provided).

/* --- Groovy DSL (build.gradle) --- */
android {
    // ... existing configuration ...

    packagingOptions {
        resources {
            excludes += [
                "META-INF/DEPENDENCIES",
                "META-INF/LICENSE",
                "META-INF/LICENSE.txt",
                "META-INF/NOTICE",
                "META-INF/NOTICE.txt",
                "META-INF/AL2.0",
                "META-INF/LGPL2.1"
            ]
        }
    }

    splits {
        abi {
            enable true
            reset()
            include 'arm64-v8a' // matches ABI_FILTERS=arm64-v8a in gradle.properties
            universalApk false
        }
    }

    defaultConfig {
        // ... existing defaultConfig ...
        ndk {
            abiFilters "arm64-v8a"
        }
    }
}

/* --- Kotlin DSL (build.gradle.kts) ---
// If your app uses Kotlin DSL, use this form inside the android { } block:

packagingOptions {
    resources.excludes.addAll(
        setOf(
            "META-INF/DEPENDENCIES",
            "META-INF/LICENSE",
            "META-INF/LICENSE.txt",
            "META-INF/NOTICE",
            "META-INF/NOTICE.txt",
            "META-INF/AL2.0",
            "META-INF/LGPL2.1"
        )
    )
}

splits {
    abi {
        isEnable = true
        reset()
        include("arm64-v8a") // matches ABI_FILTERS=arm64-v8a
        isUniversalApk = false
    }
}

defaultConfig {
    ndk {
        abiFilters += "arm64-v8a"
    }
}
*/
