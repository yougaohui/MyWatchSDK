# SDK 更新摘要 / SDK Update Summary / SDK更新概要

## 📋 快速概览 / Quick Overview / クイック概要

**版本 / Version / バージョン:** 1.0 → 2.0  
**日期 / Date / 日付:** 2025-12-05

---

## 🔄 变更清单 / Change List / 変更リスト

### 1️⃣ 新增字段 / New Fields / 新規フィールド

| 字段 / Field / フィールド | 类型 / Type / 型 | 说明 / Description / 説明 |
|--------------------------|-----------------|-------------------------|
| heartRatePPI | int | 心率PPI / Heart Rate PPI / 心拍PPI |
| riskStatus | int | 风险状态 / Risk Status / リスクステータス |
| extraData | byte[] | 扩展数据 / Extension Data / 拡張データ |

### 2️⃣ Bug 修复 / Bug Fixes / バグ修正

✅ **心率PPI字节序修复 / Heart Rate PPI Byte Order Fix / 心拍PPIバイト順修正**
- 从大端改为小端 / Changed from Big Endian to Little Endian / ビッグエンディアンからリトルエンディアンに変更
- 示例 / Example / 例: `20030000` → 800

✅ **动态协议长度适配 / Dynamic Protocol Length Adaptation / 動的プロトコル長対応**
- 自动识别4/8/9字节协议 / Auto-detect 4/8/9 byte protocols / 4/8/9バイトプロトコルを自動認識
- 完全向后兼容 / Fully backward compatible / 完全な後方互換性

### 3️⃣ UI 优化 / UI Optimization / UI最適化

📱 **显示方式改进 / Display Improvement / 表示方法の改善**
- Toast → AlertDialog
- 更好的可读性 / Better readability / より良い可読性

---

## 📊 协议对比 / Protocol Comparison / プロトコル比較

| 版本 / Version | 长度 / Length | 字段 / Fields |
|---------------|--------------|--------------|
| 旧版 / Legacy / 旧版 | 4 bytes | 基础3字段 / Basic 3 fields / 基本3フィールド |
| 当前 / Current / 現在 | 9 bytes | 基础+心率PPI+风险 / Basic+PPI+Risk / 基本+PPI+リスク |
| 未来 / Future / 将来 | 10+ bytes | 全部+扩展 / All+Extra / 全て+拡張 |

---

## 🔧 受影响文件 / Affected Files / 影響を受けるファイル

### SDK 核心 / SDK Core / SDKコア
- ✏️ `TempCheckModel.java` - 数据模型 / Data Model / データモデル
- ✏️ `ReceiveData.java` - 数据解析 / Data Parsing / データ解析

### Demo 应用 / Demo App / デモアプリ
- ✏️ `MainActivity.java` - UI展示 / UI Display / UI表示

---

## ⚠️ 注意事项 / Important Notes / 重要事項

### 中文
1. **兼容性：** 完全向后兼容，旧设备无需升级
2. **字节序：** 心率PPI使用小端序（Little Endian）
3. **默认值：** 新字段在旧协议下默认为0或null

### English
1. **Compatibility:** Fully backward compatible, no upgrade needed for old devices
2. **Byte Order:** Heart Rate PPI uses Little Endian
3. **Default Values:** New fields default to 0 or null in old protocols

### 日本語
1. **互換性：** 完全な後方互換性、旧デバイスのアップグレード不要
2. **バイト順：** 心拍PPIはリトルエンディアンを使用
3. **デフォルト値：** 新規フィールドは旧プロトコルで0またはnullがデフォルト

---

## 📝 代码示例 / Code Example / コード例

```java
// 获取温度数据 / Get temperature data / 温度データを取得
TempCheckModel model = event.getTempCheck();

// ✨ 新增字段使用 / New field usage / 新規フィールド使用
int heartRatePPI = model.getHeartRatePPI();      // 心率PPI / Heart Rate PPI / 心拍PPI
String riskText = model.getRiskStatusText();     // "正常" / "Normal" / "正常"
byte[] extra = model.getExtraData();             // 扩展数据 / Extra data / 拡張データ
```

---

## ✅ 测试验证 / Testing / テスト

| 测试项 / Test Item / テスト項目 | 状态 / Status / ステータス |
|--------------------------------|--------------------------|
| 旧协议兼容 / Legacy Protocol / 旧プロトコル | ✅ 通过 / Passed / 合格 |
| 新协议解析 / New Protocol / 新プロトコル | ✅ 通过 / Passed / 合格 |
| UI显示 / UI Display / UI表示 | ✅ 通过 / Passed / 合格 |
| 字节序验证 / Byte Order / バイト順 | ✅ 通过 / Passed / 合格 |

---

📅 **更新日期 / Update Date / 更新日:** 2025-12-05  
📦 **文档版本 / Document Version / ドキュメントバージョン:** 1.0

