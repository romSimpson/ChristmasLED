# ChristmasFlair

"""

based off of 


classDiagram
class localTime {
- hour: int
- minute: int
+ localTime(hour: int, minute: int)
+ getHour(): int
+ setHour(hour: int): void
+ getMinute(): int
+ setMinute(minute: int): void
+ isAfter(other: localTime): boolean
+ isBefore(other: localTime): boolean
+ now(): localTime
+ of(hour: int, minute: int): localTime
}

class PixelColor {
- red: int
- green: int
- blue: int
+ PixelColor(red: int, green: int, blue: int)
+ getRed(): int
+ setRed(red: int): void
+ getGreen(): int
+ setGreen(green: int): void
+ getBlue(): int
+ setBlue(blue: int): void
}

class ledTimer {
- startTime: localTime
- endTime: localTime
- ledState: boolean
- ledDriver: Ws281xLedDriverInterface
- ledCount: int
+ ledTimer(ledCount: int, startTime: localTime, endTime: localTime)
+ setStartTime(startTime: localTime): void
+ setEndTime(endTime: localTime): void
+ turnOn(): void
+ turnOff(): void
+ isLedOn(): boolean
+ getStartTime(): localTime
+ getEndTime(): localTime
- initLedStrip(): void
}
![img.png](../../img.png)
"""
