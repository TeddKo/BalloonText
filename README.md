# BalloonText

[![Maven Central](https://img.shields.io/maven-central/v/io.github.teddko/balloontext.svg)](https://search.maven.org/artifact/io.github.teddko/balloontext/1.0.0/aar)
[![API](https://img.shields.io/badge/API-23%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=23)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

BalloonText is a customizable chat bubble text component library for Jetpack Compose. It provides an easy way to create stylish chat bubble UI components with various customization options.
</br></br>
![balloontext](https://github.com/user-attachments/assets/7bba0e32-9ec5-414a-b234-28ff0a4c866e)



## Features

- Four tail directions (right-top, left-top, right-bottom, left-bottom)
- Three preset shape sizes (large, medium, small)
- Customizable colors and padding
- Smooth corner radius
- Natural tail shape

## Installation

Add the following dependency to your app's build.gradle.kts file:

```kotlin
dependencies {
    implementation("io.github.teddko:balloontext:1.0.0")
}
```

## Usage

Basic example:

```kotlin
BalloonText(
    balloonDirection = BalloonDirection.LEFT_TOP,
    balloonTextShape = BalloonTextShape.MEDIUM_SHAPE,
    balloonColor = MaterialTheme.colorScheme.primary,
    text = "Hello!"
)
```

Custom styling example:

```kotlin
BalloonText(
    modifier = Modifier.padding(8.dp),
    balloonDirection = BalloonDirection.RIGHT_BOTTOM,
    balloonTextShape = BalloonTextShape.LARGE_SHAPE,
    textPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
    balloonColor = Color(0xFF2196F3),
    text = "This is a custom styled balloon!",
    textColor = Color.White
)
```

## Parameters

| Parameter | Description | Default |
|-----------|-------------|---------|
| modifier | Modifier to be applied to the component | Modifier |
| balloonDirection | Direction of the balloon's tail | - |
| balloonTextShape | Preset size of the balloon shape | MEDIUM_SHAPE |
| textPadding | Internal padding for the text content | PaddingValues(10.dp) |
| balloonColor | Background color of the balloon | - |
| text | Text to be displayed | - |
| textColor | Color of the text | MaterialTheme.colorScheme.surface |

## BalloonDirection

Enum class that specifies the direction of the balloon's tail:

- `RIGHT_TOP`
- `LEFT_TOP`
- `RIGHT_BOTTOM`
- `LEFT_BOTTOM`

## BalloonTextShape

Enum class that defines the size preset of the balloon:

- `LARGE_SHAPE`: Large size (corner radius 18.dp)
- `MEDIUM_SHAPE`: Medium size (corner radius 15.dp)
- `SMALL_SHAPE`: Small size (corner radius 8.dp)

## Sample App

For more examples and use cases, check out the sample app in the [GitHub repository](https://github.com/teddko/balloontext/tree/main/demo).

## Contributing

We welcome contributions! If you would like to contribute to this project, please follow these steps:

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Requirements

- Android SDK 23+
- Jetpack Compose 1.7.5+

## License

```
                                 Apache License
                           Version 2.0, January 2004
                        http://www.apache.org/licenses/

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```

## Author

TeddKo - [@teddko](https://github.com/teddko)

Project Link: [https://github.com/teddko/balloontext](https://github.com/teddko/balloontext)
