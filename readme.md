# Persistence

- Shared Preferences
    - Add strings to Constants bro, you did not do that
- Files
- SQLite

## Plus

- ScrollView, in case of tiny phones on landscape
- How to know in a debug moment which value is in shared preferences? [Stetho](https://facebook.github.io/stetho)
    - Add DP
    - Initialize it building `Application` class
        - Call it into Android Manifest adding/changing `name` property
- What if I want to update if shared preferences variable's value changes?
    - RX Java
    - Event Bus
    - Listener

## DB - SQLite

- Initialize `initializeInstance` into our app just once