# Temperature Check SDK Update Documentation

Version: 2.0  
Update Date: 2025-12-05

---

## Overview

This update primarily focuses on protocol extension and bug fixes for temperature check functionality, adding heart rate PPI and risk status fields, and optimizing data parsing logic for backward compatibility.

## Main Updates

### 1. TempCheckModel Extension

**New Fields:**

| Field Name | Type | Description | Default Value |
|------------|------|-------------|---------------|
| heartRatePPI | int | Heart Rate PPI (Little Endian) | 0 |
| riskStatus | int | Risk Status (0=Normal, 1=Medium, 2=High) | 0 |
| extraData | byte[] | Extra data for future protocol extension | null |

**New Methods:**
- `int getHeartRatePPI()` - Get heart rate PPI value
- `int getRiskStatus()` - Get risk status value
- `String getRiskStatusText()` - Get risk status text description
- `byte[] getExtraData()` - Get extra extension data

**File Path:**
`mywatchsdklib/src/main/java/com/legend/mywatch/sdk/mywatchsdklib/android/model/TempCheckModel.java`

### 2. Protocol Parsing Optimization

**2.1 Protocol Structure (72bit/9bytes support)**

| Byte Position | Bits | Field | Description |
|--------------|------|-------|-------------|
| 1-4 | 32bit | Basic Data | timestamp(11bit) + temperature(13bit) + powerOnCount(8bit) |
| 5-8 | 32bit | heartRatePPI | Heart Rate PPI (Little Endian) |
| 9 | 8bit | riskStatus | Risk Status |
| 10+ | Variable | extraData | Extra Data (Optional) |

**2.2 Parsing Logic Fixes**

- **Heart Rate PPI Byte Order Fix:** Changed from Big Endian to Little Endian
  - Example: `20 03 00 00` → 800 (0x320)
  
- **Dynamic Item Length Calculation:** Supports 4/8/9 bytes and other protocol versions
  - Formula: `itemLength = contentBytes.length / itemNum`
  - Auto-adapts to old protocol (4 bytes) and new protocol (8/9 bytes)

**File Path:**
`mywatchsdklib/src/main/java/com/legend/mywatch/sdk/mywatchsdklib/android/bluetooth/ReceiveData.java`

### 3. Demo Application Update

**Display Optimization:**
- Changed from Toast to AlertDialog for temperature check data display
- Added new field display: Heart Rate PPI, Risk Status, Extra Data Length

**File Path:**
`app/src/main/java/com/legend/mywatch/sdk/android/MainActivity.java`

## Protocol Compatibility

| Protocol Version | Data Length | Supported Fields | Compatibility |
|-----------------|-------------|------------------|---------------|
| Legacy Protocol | 4 bytes | timestamp, temperature, powerOnCount | ✅ Fully Compatible |
| Heart Rate PPI Protocol | 8 bytes | Basic Fields + heartRatePPI | ✅ Fully Compatible |
| Complete Protocol | 9 bytes | Basic Fields + heartRatePPI + riskStatus | ✅ Fully Compatible |
| Future Extension | 10+ bytes | All Fields + extraData | ✅ Auto-Adaptive |

## Usage Example

```java
// Get temperature check data
TempCheckModel model = event.getTempCheck();

// Basic fields
int timestamp = model.getTimestamp();        // Timestamp (minutes)
float temperature = model.getTemperature();  // Temperature (℃)
int powerOnCount = model.getPowerOnCount();  // Power on count

// New fields
int heartRatePPI = model.getHeartRatePPI();  // Heart Rate PPI
int riskStatus = model.getRiskStatus();      // Risk status value (0/1/2)
String riskText = model.getRiskStatusText(); // Risk status text ("Normal"/"Medium"/"High")
byte[] extraData = model.getExtraData();     // Extra data
```

## Important Notes

1. **Backward Compatibility:** All new fields have reasonable default values (0 or null) in old protocols, without affecting existing functionality
2. **Byte Order:** Heart Rate PPI uses Little Endian
3. **Extensibility:** extraData field reserves space for future protocol extensions

---

## Change Log

| Date | Version | Description |
|------|---------|-------------|
| 2025-12-05 | 2.0 | Initial Release |

## Contact

For questions, please contact the technical support team.

