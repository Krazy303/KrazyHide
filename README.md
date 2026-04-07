# KrazyHide

KrazyHide is a privacy-first Android application designed to protect your screen in real-time. Using on-device AI models, KrazyHide detects sensitive content (such as people) and automatically applies customizable overlays, ensuring your privacy during screen sharing, recording, or in public spaces.

## Features

- **AI-Powered Detection**: Real-time detection of people and objects using optimized TFLite models.
- **Privacy by Design**: All processing happens locally on your device. KrazyHide has **no internet permission**, ensuring your data never leaves the device.
- **Multiple Modes**:
    - **Precision Mode**: Uses a larger AI model for higher accuracy on high-end devices.
    - **Detailed Mode**: Recognizes exact shapes to avoid obscuring nearby content.
    - **Normal Mode**: Efficient rectangular masking for balanced performance.
- **Customizable Overlays**: Adjustable pixelation levels and opacity to suit your needs.
- **Auto-Start**: Automatically begins protection when selected apps are launched via Accessibility Services.
- **Modern UI**: Built with Jetpack Compose and Material 3, featuring a "Squircle" aesthetic for a premium feel.

## Requirements

- Android 10 (API 29) or higher.
- Support for "Single App" recording (Android 14/15+) is highly recommended for the best experience.

## Build Instructions

To build the project locally:

1. Clone the repository.
2. Open the project in Android Studio.
3. Ensure you have the Android SDK and NDK configured.
4. Build the project using Gradle:
   ```bash
   ./gradlew assembleDebug
   ```

---

## License

**Copyright (c) 2026 KrazyHide Authors**

### Custom License Terms

This software is provided for personal use only. By using, downloading, or accessing the source code, you agree to the following restrictive conditions:

1. **No Distribution**: You may not distribute, sub-license, rent, lease, or lend this software, its source code, or compiled binaries to any third party in any form (original or modified).
2. **No Renaming/Rebranding**: You are strictly prohibited from renaming the project, changing its branding (including logos and app names), or representing it as your own work.
3. **No Commercial Use**: This software may not be used for commercial purposes without explicit written consent from the author.
4. **Source Code Access**: You may modify the source code for personal, private use only. Modified versions are subject to the same "No Distribution" and "No Renaming" rules.

**THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED.**
