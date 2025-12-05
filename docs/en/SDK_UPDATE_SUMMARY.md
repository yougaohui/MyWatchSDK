# SDK Update Summary

## 📋 Quick Overview

**Version:** 1.0 → 2.0  
**Date:** 2025-12-05

---

## 🔄 Change List

### 1️⃣ New Fields

| Field | Type | Description |
|-------|------|-------------|
| heartRatePPI | int | Heart Rate PPI |
| riskStatus | int | Risk Status |
| extraData | byte[] | Extension Data |

### 2️⃣ Bug Fixes

✅ **Heart Rate PPI Byte Order Fix**
- Changed from Big Endian to Little Endian
- Example: `20030000` → 800

✅ **Dynamic Protocol Length Adaptation**
- Auto-detect 4/8/9 byte protocols
- Fully backward compatible

### 3️⃣ UI Optimization

📱 **Display Improvement**
- Toast → AlertDialog
- Better readability

---

## 📊 Protocol Comparison

| Version | Length | Fields |
|---------|--------|--------|
| Legacy | 4 bytes | Basic 3 fields |
| Current | 9 bytes | Basic+PPI+Risk |
| Future | 10+ bytes | All+Extra |

---

## 🔧 Affected Files

### SDK Core
- ✏️ `TempCheckModel.java` - Data Model
- ✏️ `ReceiveData.java` - Data Parsing

### Demo App
- ✏️ `MainActivity.java` - UI Display

---

## ⚠️ Important Notes

1. **Compatibility:** Fully backward compatible, no upgrade needed for old devices
2. **Byte Order:** Heart Rate PPI uses Little Endian
3. **Default Values:** New fields default to 0 or null in old protocols

---

## 📝 Code Example

```java
// Get temperature data
TempCheckModel model = event.getTempCheck();

// ✨ New field usage
int heartRatePPI = model.getHeartRatePPI();      // Heart Rate PPI
String riskText = model.getRiskStatusText();     // "Normal"
byte[] extra = model.getExtraData();             // Extra data
```

---

## ✅ Testing

| Test Item | Status |
|-----------|--------|
| Legacy Protocol | ✅ Passed |
| New Protocol | ✅ Passed |
| UI Display | ✅ Passed |
| Byte Order | ✅ Passed |

---

📅 **Update Date:** 2025-12-05  
📦 **Document Version:** 1.0

