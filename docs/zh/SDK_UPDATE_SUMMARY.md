# SDK 更新摘要

## 📋 快速概览

**版本:** 1.0 → 2.0  
**日期:** 2025-12-05

---

## 🔄 变更清单

### 1️⃣ 新增字段

| 字段 | 类型 | 说明 |
|------|------|------|
| heartRatePPI | int | 心率PPI |
| riskStatus | int | 风险状态 |
| extraData | byte[] | 扩展数据 |

### 2️⃣ Bug 修复

✅ **心率PPI字节序修复**
- 从大端改为小端
- 示例: `20030000` → 800

✅ **动态协议长度适配**
- 自动识别4/8/9字节协议
- 完全向后兼容

### 3️⃣ UI 优化

📱 **显示方式改进**
- Toast → AlertDialog
- 更好的可读性

---

## 📊 协议对比

| 版本 | 长度 | 字段 |
|-----|------|------|
| 旧版 | 4 bytes | 基础3字段 |
| 当前 | 9 bytes | 基础+心率PPI+风险 |
| 未来 | 10+ bytes | 全部+扩展 |

---

## 🔧 受影响文件

### SDK 核心
- ✏️ `TempCheckModel.java` - 数据模型
- ✏️ `ReceiveData.java` - 数据解析

### Demo 应用
- ✏️ `MainActivity.java` - UI展示

---

## ⚠️ 注意事项

1. **兼容性：** 完全向后兼容，旧设备无需升级
2. **字节序：** 心率PPI使用小端序（Little Endian）
3. **默认值：** 新字段在旧协议下默认为0或null

---

## 📝 代码示例

```java
// 获取温度数据
TempCheckModel model = event.getTempCheck();

// ✨ 新增字段使用
int heartRatePPI = model.getHeartRatePPI();      // 心率PPI
String riskText = model.getRiskStatusText();     // "正常"
byte[] extra = model.getExtraData();             // 扩展数据
```

---

## ✅ 测试验证

| 测试项 | 状态 |
|-------|------|
| 旧协议兼容 | ✅ 通过 |
| 新协议解析 | ✅ 通过 |
| UI显示 | ✅ 通过 |
| 字节序验证 | ✅ 通过 |

---

📅 **更新日期:** 2025-12-05  
📦 **文档版本:** 1.0

