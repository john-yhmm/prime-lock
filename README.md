# PrimeLock

## Overview
PrimeLock is a project developed for our first-year university Object-Oriented Programming (OOP) course. The goal of this assignment was to design software for a niche demographic using OOP concepts, and we chose to create a passcode management tool tailored for mechanical vault operators in banks.

**Project group members:**  
Sai Aike Shwe Tun Aung  
Ye Htet Maung Maung  
Thiha Phone Thaw

## What Does PrimeLock Do?
Vaults often require long numerical passcodes, which can be cumbersome to remember and manage. PrimeLock helps by:
- **Encoding** numerical passcodes into alphanumeric strings using base-62 encoding.
- **Encrypting** the passcodes using a simple 3-step Caesar Cipher for added security.
- Implementing an **authentication** or login system requiring a passport ID or citizenship ID and password.
- **Configurable** encryption key for the encryption algorithm.

Users can write down the encrypted passcode on paper and decrypt it when needed, ensuring security since only authorized users can decrypt it.


## Technologies Used
- **Language:** Java (since our course uses Java as a main language to teach OOP concepts)
- **GUI Framework:** Java Swing
- **Encoding:** Base-62 (using numbers, all lowercase and uppercase characters of the English alphabet)
- **Encryption:** 3-step Caesar Cipher with a configurable encryption key.

## Notes
This is a learning project, and while we have implemented encryption and security measures, it is not intended for real-world secure applications. We also wrote the encoding algorithm and encryption algorithms by ourselves, so it is quite simple. Thanks for checking it out :D

---
