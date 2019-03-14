package com.weima.Http;

//import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.math.BigInteger;

public class HttpPheonix {

    public static void main(String[] args){
        System.out.println(new BigInteger("423423432423"));

        String items = "{VCU_VhclActlGearPos:0,GPS_Status:0,TPMS_PressureValue_RR:701.25," +
                "TPMS_PressureValue_FL:701.25,ESC_VehicleSpeed:0.0,BMS_CellInconsistencyWrning:0," +
                "VCU_MotorTemp:20,BMS_BatteryOverVolWrning:0,VCU_DrvRangeDistEst:210," +
                "TPMS_PressureValue_FR:701.25,VCU_MotorHighTempWrning:0,BCM_AjarSta_Trunk:0," +
                "BMS_HighTempWrning:0,BMS_LowSOCWrning:0,VCU_MCU_Input_Vol:382.0," +
                "BMS_CellVol:[4.245000,4.253000,4.254000,4.255000,4.258000,4.259000,4.258000,4.244000,4.243000,4.245000,4.248000,4.258000,4.253000,4.259000,4.252000,4.246000,4.252000,4.256000,4.257000,4.262000,4.260000,4.256000,4.258000,4.259000,4.254000,4.254000,4.253000,4.246000,4.257000,4.244000,4.251000,4.251000,4.258000,4.259000,4.255000,4.254000,4.254000,4.256000,4.258000,4.255000,4.249000,4.248000,4.246000,4.244000,4.244000,4.246000,4.257000,4.259000,4.254000,4.251000,4.261000,4.259000,4.247000,4.246000,4.256000,4.257000,4.258000,4.254000,4.262000,4.254000,4.249000,4.258000,4.258000,4.260000,4.262000,4.252000,4.262000,4.258000,4.257000,4.261000,4.254000,4.260000,4.258000,4.257000,4.255000,4.248000,4.258000,4.259000,4.261000,4.258000,4.260000,4.256000,4.256000,4.256000,4.263000,4.248000,4.252000,4.255000,4.247000,4.246000]," +
                "BCM_SysPwrMode:2,TPMS_PressureValue_RL:701.25,BCM_DoorAjarSta_FL:0,BCM_DoorAjarSta_FR:0," +
                "BMS_TotalTempProbe:24,BMS_BatteryDTC_Num:1,BMS_CellVolMax:4.263,BCM_DoorAjarSta_RR:0," +
                "VCU_MotorDTC_Num:1,BMS_MinVolCellCod:9,VCU_ActlMotorRotateSpd:0,AC_ActlOprtMode:2," +
                "BMS_CellUnderrVolWrning:0,SRS_CrashOutputSts:0,BMS_DCS_ActOprtMode:0,VCU_Actl_MotorTorque:0.0," +
                "BMS_BatSOH:100.0,BCM_RL_wdw_Opend:1,BMS_CellVolMin:4.243,BMS_TotalCellNo:90,ESC_NoBrakeForce:0," +
                "BMS_MaxVolCellCod:65," +
                "BMS_TempProbe:[21,22,21,22,21,22,21,22,21,21,21,21,21,21,21,22,21,21,21,21,20,21,21,21]," +
                "BCM_DoorAjarSta_RL:0,BMS_BatteryDTC_List:[13698951],BMS_BatteryOverChrgWrning:0," +
                "BCM_SysPowerSts:1,BMS_HighSOCWrning:0,OBC_ActlOprtMode:4,BCM_LowBeamSta:1," +
                "BMS_MaxTempProbeCod:2,BMS_IsoResistance:2.48,VCU_MotorDTC_List:[134293416]," +
                "AC_IndoorTemp:19.5,VCU_AcclPedalPos:0.0,BCM_DoorLockSta_FL:0," +
                "BCM_RR_wdw_Opend:1,ICU_ICUTotalOdometer:10415.5,OBC_InletConnctSta:0," +
                "VCU_PTActlOprtMode:2,BMS_CellOverVolWrning:0,BMS_HVBatCellTempMin:20,BMS_AbnormallSOCWrning:0," +
                "VCU_BrkPedalPos:4.8,VCU_PwrRecupIntensity:0,BCM_Pas_wdw_Opend:1,BMS_ActlExchgCurnt:0.9," +
                "VCU_MCU_Input_Curr:0.0,BMS_HVBatCellTempMax:22,GPS_Latitude:0.0,VCU_MCUHighTempWrning:0," +
                "EPB_WarnLampSta:0,BMS_TempDifferWrning:0,VCU_DrvMotorSta:3,BMS_BatSOC_Rpt:100.0," +
                "BMS_HighVolInterLockWrning:0,DCC_OverTemperatureFail:0,BMS_BatteryUnderrVolWrning:0," +
                "VCU_MCU_Temp:21,VCU_VehActlDrvMode:1,BMS_HVBatActlVoltage:382.9,DCC_ActlOprtMode:2," +
                "BCM_Drv_wdw_Opend:1,BMS_DCS_InletConnectSta:0,BMS_InsulationWrning:0,BMS_MinTempProbeCod:21," +
                "GPS_Longitude:0.0,BMS_ACChrgAtclSta:0,BMS_BatterytSysMismatchingWrning:0,SrPosition:3," +
                "BCM_DoorLockSta_FR_RL_RR:0}";

        String item = "{\"VCU_VhclActlGearPos\":0,\"GPS_Status\":0,\"TPMS_PressureValue_RR\":701.25," +
                "\"TPMS_PressureValue_FL\":701.25,\"ESC_VehicleSpeed\":0.0," +
                "\"BMS_CellInconsistencyWrning\":0,\"VCU_MotorTemp\":20,\"BMS_BatteryOverVolWrning\":0" +
                ",\"VCU_DrvRangeDistEst\":210,\"TPMS_PressureValue_FR\":701.25," +
                "\"VCU_MotorHighTempWrning\":0,\"BCM_AjarSta_Trunk\":0,\"BMS_HighTempWrning\":0," +
                "\"BMS_LowSOCWrning\":0,\"VCU_MCU_Input_Vol\":382.0," +
                "\"BMS_CellVol\":[4.245000,4.253000,4.254000,4.255000,4.258000,4.259000,4.258000,4.244000,4.243000,4.245000,4.248000,4.258000,4.253000,4.259000,4.252000,4.246000,4.252000,4.256000,4.257000,4.262000,4.260000,4.256000,4.258000,4.259000,4.254000,4.254000,4.253000,4.246000,4.257000,4.244000,4.251000,4.251000,4.258000,4.259000,4.255000,4.254000,4.254000,4.256000,4.258000,4.255000,4.249000,4.248000,4.246000,4.244000,4.244000,4.246000,4.257000,4.259000,4.254000,4.251000,4.261000,4.259000,4.247000,4.246000,4.256000,4.257000,4.258000,4.254000,4.262000,4.254000,4.249000,4.258000,4.258000,4.260000,4.262000,4.252000,4.262000,4.258000,4.257000,4.261000,4.254000,4.260000,4.258000,4.257000,4.255000,4.248000,4.258000,4.259000,4.261000,4.258000,4.260000,4.256000,4.256000,4.256000,4.263000,4.248000,4.252000,4.255000,4.247000,4.246000]," +
                "\"BCM_SysPwrMode\":2,\"TPMS_PressureValue_RL\":701.25,\"BCM_DoorAjarSta_FL\":0," +
                "\"BCM_DoorAjarSta_FR\":0,\"BMS_TotalTempProbe\":24,\"BMS_BatteryDTC_Num\":1," +
                "\"BMS_CellVolMax\":4.263,\"BCM_DoorAjarSta_RR\":0,\"VCU_MotorDTC_Num\":1," +
                "\"BMS_MinVolCellCod\":9,\"VCU_ActlMotorRotateSpd\":0,\"AC_ActlOprtMode\":2," +
                "\"BMS_CellUnderrVolWrning\":0,\"SRS_CrashOutputSts\":0,\"BMS_DCS_ActOprtMode\":0," +
                "\"VCU_Actl_MotorTorque\":0.0,\"BMS_BatSOH\":100.0,\"BCM_RL_wdw_Opend\":1," +
                "\"BMS_CellVolMin\":4.243,\"BMS_TotalCellNo\":90,\"ESC_NoBrakeForce\":0," +
                "\"BMS_MaxVolCellCod\":65," +
                "\"BMS_TempProbe\":[21,22,21,22,21,22,21,22,21,21,21,21,21,21,21,22,21,21,21,21,20,21,21,21]," +
                "\"BCM_DoorAjarSta_RL\":0,\"BMS_BatteryDTC_List\":[13698951],\"BMS_BatteryOverChrgWrning\":0," +
                "\"BCM_SysPowerSts\":1,\"BMS_HighSOCWrning\":0,\"OBC_ActlOprtMode\":4,\"BCM_LowBeamSta\":1," +
                "\"BMS_MaxTempProbeCod\":2,\"BMS_IsoResistance\":2.48,\"VCU_MotorDTC_List\":[134293416]," +
                "\"AC_IndoorTemp\":19.5,\"VCU_AcclPedalPos\":0.0,\"BCM_DoorLockSta_FL\":0," +
                "\"BCM_RR_wdw_Opend\":1,\"ICU_ICUTotalOdometer\":10415.5,\"OBC_InletConnctSta\":0," +
                "\"VCU_PTActlOprtMode\":2,\"BMS_CellOverVolWrning\":0,\"BMS_HVBatCellTempMin\":20," +
                "\"BMS_AbnormallSOCWrning\":0,\"VCU_BrkPedalPos\":4.8,\"VCU_PwrRecupIntensity\":0," +
                "\"BCM_Pas_wdw_Opend\":1,\"BMS_ActlExchgCurnt\":0.9,\"VCU_MCU_Input_Curr\":0.0," +
                "\"BMS_HVBatCellTempMax\":22,\"GPS_Latitude\":0.0,\"VCU_MCUHighTempWrning\":0," +
                "\"EPB_WarnLampSta\":0,\"BMS_TempDifferWrning\":0,\"VCU_DrvMotorSta\":3," +
                "\"BMS_BatSOC_Rpt\":100.0,\"BMS_HighVolInterLockWrning\":0,\"DCC_OverTemperatureFail\":0," +
                "\"BMS_BatteryUnderrVolWrning\":0,\"VCU_MCU_Temp\":21,\"VCU_VehActlDrvMode\":1," +
                "\"BMS_HVBatActlVoltage\":382.9,\"DCC_ActlOprtMode\":2,\"BCM_Drv_wdw_Opend\":1," +
                "\"BMS_DCS_InletConnectSta\":0,\"BMS_InsulationWrning\":0,\"BMS_MinTempProbeCod\":21," +
                "\"GPS_Longitude\":0.0,\"BMS_ACChrgAtclSta\":0,\"BMS_BatterytSysMismatchingWrning\":0," +
                "\"SrPosition\":3,\"BCM_DoorLockSta_FR_RL_RR\":0}";
//
//        JsonObject json = gson.fromJson(items, JsonObject.class);
//        System.out.println(gson.fromJson(item,JsonObject.class));

        JSON.parseObject(item);

//        JSONObject jsonObject = JSONObject.parseObject(item);

//        System.out.println(jsonObject.get("ESC_VehicleSpeed"));

//        JSONObject json = JSONObje;
    }
    public void getConnection(){

    }
}
