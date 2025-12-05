# 温度检测SDK更新文档

版本: 2.0  
更新日期: 2025-12-05

---

## 概述

本次更新主要针对温度检测功能进行了协议扩展和bug修复，新增了心率PPI和风险状态字段，并优化了数据解析逻辑以支持协议向后兼容。

## 主要更新内容

### 1. TempCheckModel 模型扩展

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

### 2. 协议解析优化

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

### 3. Demo 应用更新

**显示优化：**
- 从 Toast 改为 AlertDialog 显示温度检测数据
- 新增数据字段展示：心率PPI、风险状态、额外数据长度

**文件路径：**
`app/src/main/java/com/legend/mywatch/sdk/android/MainActivity.java`

## 协议兼容性

| 协议版本 | 数据长度 | 支持字段 | 兼容性 |
|---------|---------|---------|--------|
| 旧协议 | 4字节 | timestamp, temperature, powerOnCount | ✅ 完全兼容 |
| 心率PPI协议 | 8字节 | 基础字段 + heartRatePPI | ✅ 完全兼容 |
| 完整协议 | 9字节 | 基础字段 + heartRatePPI + riskStatus | ✅ 完全兼容 |
| 未来扩展 | 10+字节 | 全部字段 + extraData | ✅ 自动适应 |

## 使用示例

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

## 重要说明

1. **向后兼容：** 所有新增字段在旧协议下都有合理的默认值（0或null），不会影响现有功能
2. **字节序：** 心率PPI使用小端序（Little Endian）
3. **扩展性：** extraData字段为未来协议扩展预留空间

---

## 更新履歴

| 日期 | 版本 | 说明 |
|-----|------|------|
| 2025-12-05 | 2.0 | 初版发布 |

## 联系方式

如有疑问，请联系技术支持团队。

