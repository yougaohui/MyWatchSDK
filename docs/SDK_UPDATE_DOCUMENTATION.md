# 温度检测SDK更新文档 / Temperature Check SDK Update Documentation / 温度チェックSDK更新ドキュメント

版本 / Version / バージョン: 2.0  
更新日期 / Update Date / 更新日: 2025-12-05

---

## 中文版本

### 概述
本次更新主要针对温度检测功能进行了协议扩展和bug修复，新增了心率PPI和风险状态字段，并优化了数据解析逻辑以支持协议向后兼容。

### 主要更新内容

#### 1. TempCheckModel 模型扩展

**新增字段：**

| 字段名 | 类型 | 说明 | 默认值 |
|--------|------|------|--------|
| heartRatePPI | int | 心率PPI值（小端序） | 0 |
| riskStatus | int | 风险状态（0=正常，1=中风险，2=高风险） | 0 |
| extraData | byte[] | 额外数据，用于未来协议扩展 | null |

**新增方法：**
- `int getHeartRatePPI()` - 获取心率PPI值
- `int getRiskStatus()` - 获取风险状态值
- `String getRiskStatusText()` - 获取风险状态文本描述
- `byte[] getExtraData()` - 获取额外扩展数据

**文件路径：**
`mywatchsdklib/src/main/java/com/legend/mywatch/sdk/mywatchsdklib/android/model/TempCheckModel.java`

#### 2. 协议解析优化

**2.1 协议结构（支持72bit/9字节）**

| 字节位置 | 位数 | 字段 | 说明 |
|---------|------|------|------|
| 1-4 | 32bit | 基础数据 | timestamp(11bit) + temperature(13bit) + powerOnCount(8bit) |
| 5-8 | 32bit | heartRatePPI | 心率PPI（小端序） |
| 9 | 8bit | riskStatus | 风险状态 |
| 10+ | 可变 | extraData | 额外数据（可选） |

**2.2 解析逻辑修复**

- **心率PPI字节序修复：** 从大端序改为小端序
  - 示例：`20 03 00 00` → 800 (0x320)
  
- **动态item长度计算：** 支持4/8/9字节等多种协议版本
  - 计算公式：`itemLength = contentBytes.length / itemNum`
  - 自动适应旧协议（4字节）和新协议（8/9字节）

**文件路径：**
`mywatchsdklib/src/main/java/com/legend/mywatch/sdk/mywatchsdklib/android/bluetooth/ReceiveData.java`

#### 3. Demo 应用更新

**显示优化：**
- 从 Toast 改为 AlertDialog 显示温度检测数据
- 新增数据字段展示：心率PPI、风险状态、额外数据长度

**文件路径：**
`app/src/main/java/com/legend/mywatch/sdk/android/MainActivity.java`

### 协议兼容性

| 协议版本 | 数据长度 | 支持字段 | 兼容性 |
|---------|---------|---------|--------|
| 旧协议 | 4字节 | timestamp, temperature, powerOnCount | ✅ 完全兼容 |
| 心率PPI协议 | 8字节 | 基础字段 + heartRatePPI | ✅ 完全兼容 |
| 完整协议 | 9字节 | 基础字段 + heartRatePPI + riskStatus | ✅ 完全兼容 |
| 未来扩展 | 10+字节 | 全部字段 + extraData | ✅ 自动适应 |

### 使用示例

```java
// 获取温度检测数据
TempCheckModel model = event.getTempCheck();

// 基础字段
int timestamp = model.getTimestamp();        // 时间戳（分钟）
float temperature = model.getTemperature();  // 温度（℃）
int powerOnCount = model.getPowerOnCount();  // 开机次数

// 新增字段
int heartRatePPI = model.getHeartRatePPI();  // 心率PPI
int riskStatus = model.getRiskStatus();      // 风险状态值（0/1/2）
String riskText = model.getRiskStatusText(); // 风险状态文本（"正常"/"中风险"/"高风险"）
byte[] extraData = model.getExtraData();     // 额外数据
```

### 重要说明

1. **向后兼容：** 所有新增字段在旧协议下都有合理的默认值（0或null），不会影响现有功能
2. **字节序：** 心率PPI使用小端序（Little Endian）
3. **扩展性：** extraData字段为未来协议扩展预留空间

---

## English Version

### Overview
This update primarily focuses on protocol extension and bug fixes for temperature check functionality, adding heart rate PPI and risk status fields, and optimizing data parsing logic for backward compatibility.

### Main Updates

#### 1. TempCheckModel Extension

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

#### 2. Protocol Parsing Optimization

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

#### 3. Demo Application Update

**Display Optimization:**
- Changed from Toast to AlertDialog for temperature check data display
- Added new field display: Heart Rate PPI, Risk Status, Extra Data Length

**File Path:**
`app/src/main/java/com/legend/mywatch/sdk/android/MainActivity.java`

### Protocol Compatibility

| Protocol Version | Data Length | Supported Fields | Compatibility |
|-----------------|-------------|------------------|---------------|
| Legacy Protocol | 4 bytes | timestamp, temperature, powerOnCount | ✅ Fully Compatible |
| Heart Rate PPI Protocol | 8 bytes | Basic Fields + heartRatePPI | ✅ Fully Compatible |
| Complete Protocol | 9 bytes | Basic Fields + heartRatePPI + riskStatus | ✅ Fully Compatible |
| Future Extension | 10+ bytes | All Fields + extraData | ✅ Auto-Adaptive |

### Usage Example

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

### Important Notes

1. **Backward Compatibility:** All new fields have reasonable default values (0 or null) in old protocols, without affecting existing functionality
2. **Byte Order:** Heart Rate PPI uses Little Endian
3. **Extensibility:** extraData field reserves space for future protocol extensions

---

## 日本語版

### 概要
今回のアップデートは、温度チェック機能のプロトコル拡張とバグ修正を中心に、心拍PPIとリスクステータスフィールドを追加し、後方互換性を維持するためにデータ解析ロジックを最適化しました。

### 主な更新内容

#### 1. TempCheckModelの拡張

**新規フィールド：**

| フィールド名 | 型 | 説明 | デフォルト値 |
|-------------|-----|------|-------------|
| heartRatePPI | int | 心拍PPI値（リトルエンディアン） | 0 |
| riskStatus | int | リスクステータス（0=正常、1=中リスク、2=高リスク） | 0 |
| extraData | byte[] | 将来のプロトコル拡張用の追加データ | null |

**新規メソッド：**
- `int getHeartRatePPI()` - 心拍PPI値を取得
- `int getRiskStatus()` - リスクステータス値を取得
- `String getRiskStatusText()` - リスクステータステキストを取得
- `byte[] getExtraData()` - 追加拡張データを取得

**ファイルパス：**
`mywatchsdklib/src/main/java/com/legend/mywatch/sdk/mywatchsdklib/android/model/TempCheckModel.java`

#### 2. プロトコル解析の最適化

**2.1 プロトコル構造（72bit/9バイト対応）**

| バイト位置 | ビット数 | フィールド | 説明 |
|-----------|---------|-----------|------|
| 1-4 | 32bit | 基本データ | timestamp(11bit) + temperature(13bit) + powerOnCount(8bit) |
| 5-8 | 32bit | heartRatePPI | 心拍PPI（リトルエンディアン） |
| 9 | 8bit | riskStatus | リスクステータス |
| 10+ | 可変 | extraData | 追加データ（オプション） |

**2.2 解析ロジックの修正**

- **心拍PPIバイト順の修正：** ビッグエンディアンからリトルエンディアンに変更
  - 例：`20 03 00 00` → 800 (0x320)
  
- **動的アイテム長の計算：** 4/8/9バイトなど複数のプロトコルバージョンに対応
  - 計算式：`itemLength = contentBytes.length / itemNum`
  - 旧プロトコル（4バイト）と新プロトコル（8/9バイト）に自動対応

**ファイルパス：**
`mywatchsdklib/src/main/java/com/legend/mywatch/sdk/mywatchsdklib/android/bluetooth/ReceiveData.java`

#### 3. デモアプリケーションの更新

**表示の最適化：**
- ToastからAlertDialogに変更して温度チェックデータを表示
- 新規フィールドの表示を追加：心拍PPI、リスクステータス、追加データ長

**ファイルパス：**
`app/src/main/java/com/legend/mywatch/sdk/android/MainActivity.java`

### プロトコル互換性

| プロトコルバージョン | データ長 | サポートフィールド | 互換性 |
|--------------------|---------|------------------|--------|
| 旧プロトコル | 4バイト | timestamp, temperature, powerOnCount | ✅ 完全互換 |
| 心拍PPIプロトコル | 8バイト | 基本フィールド + heartRatePPI | ✅ 完全互換 |
| 完全プロトコル | 9バイト | 基本フィールド + heartRatePPI + riskStatus | ✅ 完全互換 |
| 将来の拡張 | 10+バイト | 全フィールド + extraData | ✅ 自動対応 |

### 使用例

```java
// 温度チェックデータを取得
TempCheckModel model = event.getTempCheck();

// 基本フィールド
int timestamp = model.getTimestamp();        // タイムスタンプ（分）
float temperature = model.getTemperature();  // 温度（℃）
int powerOnCount = model.getPowerOnCount();  // 起動回数

// 新規フィールド
int heartRatePPI = model.getHeartRatePPI();  // 心拍PPI
int riskStatus = model.getRiskStatus();      // リスクステータス値（0/1/2）
String riskText = model.getRiskStatusText(); // リスクステータステキスト（"正常"/"中リスク"/"高リスク"）
byte[] extraData = model.getExtraData();     // 追加データ
```

### 重要な注意事項

1. **後方互換性：** すべての新規フィールドは旧プロトコルで合理的なデフォルト値（0またはnull）を持ち、既存の機能に影響しません
2. **バイト順：** 心拍PPIはリトルエンディアンを使用
3. **拡張性：** extraDataフィールドは将来のプロトコル拡張のためのスペースを予約

---

## 更新履歴 / Change Log / 変更履歴

| 日期/Date/日付 | 版本/Version/バージョン | 说明/Description/説明 |
|---------------|------------------------|---------------------|
| 2025-12-05 | 2.0 | 初版发布 / Initial Release / 初版リリース |

## 联系方式 / Contact / 連絡先

如有疑问，请联系技术支持团队。  
For questions, please contact the technical support team.  
ご質問がある場合は、技術サポートチームまでお問い合わせください。

