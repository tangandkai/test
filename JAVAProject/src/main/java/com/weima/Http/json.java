package com.weima.Http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


public class json {

    public static void main(String[] args){
        String items = "{\"HU_RCTA_EnableSw\":0,\"GPS_Status\":1,\"SRS_DrvSeatbeltBuckleValid\":0,\"TPMS_PressureValue_RR\":200.75,\"NaviSpeedLimitUnit\":0,\"ICU_DrvSeatOccupantSensorSts\":1,\"VCU_DrvRangeDistEstV\":1,\"BAT_HVHDeviceInternTemp\":13,\"BMS_BatterySubSysCod\":1,\"TPMS_PressureValue_RL\":200.75,\"EPS_ElecSteerModeSta\":1,\"TPMS_PressureSta_RR\":0,\"APA_SelectedSide\":0,\"BMS_TotalTempProbe\":48,\"VCU_BrkAPARqstV\":0,\"SCM_TurnLightLeverSta\":0,\"BCM_LightLeftOnRemind\":0,\"HU_DesgnDrvrSpdLimitSet\":0,\"BMS_BatteryDTC_List\":[],\"AVM_RoatingPosition\":2,\"BMS_BatCapacity\":153,\"VCU_DrvReqTorqOverrideESC\":0,\"BCM_DayRunLightSta\":0,\"ESC_BrakePedalSwSta\":0,\"VCU_DrvReq_MotorTorq\":0,\"BMS_HVBatCellTempMaxV\":1,\"BMS_NomCellCap\":153,\"VCU_Actl_MotorRotateSpdV\":1,\"BMS_HVBatCellTempMin\":12,\"ACC_Y\":15.625,\"ACC_X\":226.5625,\"BMS_DCS_ChargeRequest\":0,\"VCU_PwrRecupIntensity\":0,\"BCM_Pas_wdw_Opend\":0,\"HU_ChgWiperMtMdSwSet\":0,\"AC_FragranceWorkSta\":0,\"BMS_ActlExchgCurnt\":-12.9,\"BMS_HVcppltnTempMin\":12,\"VCU_LongDistEna\":0,\"GPS_Latitude\":39.997833,\"TBOX_UserCtrlRmtPark\":0,\"BMS_PwrTrainConnectSta\":1,\"ESC_EBDFailed\":1,\"TPMS_PressureSta_RL\":0,\"VCU_DrvMotorSta\":255,\"VCU_VPModeSwSet_Rsvd\":0,\"ESC_TrgtGearReqV\":0,\"HU_TSR_EnableSw\":0,\"BMS_RunState\":3,\"BMS_HVBatCellTempAveV\":1,\"VCU_VhclActlGearPos\":1,\"EGSM_TimeoutFlag\":0,\"AC_SeatHeatFb_FL\":0,\"BCM_ATWSLightOnReq_PT\":1,\"BMS_BatSOC_Actl\":77.5,\"BMS_CellInconsistencyWrning\":0,\"VCU_TimeoutFlag\":0,\"AC_RefrgHiPressureV\":1,\"BAT_PumpEnb\":0,\"BCM_BrakeLampSta\":0,\"HU_SlwChrgAjarCur\":0,\"AC_SeatHeatFb_FR\":0,\"BMS_HVcppltnTempmax\":13,\"BCM_FuelAjarSta_Reserved\":0,\"AC_ActTotalPower\":0,\"BTMS_OilLevelWarningFlag\":1,\"VCU_PeristalsisModeFb\":0,\"VCU_GearShiftInhibited\":1,\"BCM_DoorAjarSta_RR\":0,\"VCU_MotPumpSta_reserved\":1,\"SRS_CrashOutputSts\":0,\"APA_ButtonPress\":0,\"BAT_FailSta\":1,\"SCM_TimeoutFlag\":0,\"BMS_CellVolMin\":3.987,\"BCM_DoorAjarSta_RL\":0,\"BCM_TimeoutFlag\":0,\"ICU_ICUTripAOdometer\":343.3,\"AC_IndoorTemp\":7.5,\"VCU_AcclPedalPos\":0,\"BCM_RR_wdw_Opend\":0,\"VCU_PTActlOprtMode\":1,\"TBOX_Err\":0,\"BMS_HVBatCellTempAve\":12,\"AVM_Camera_Rear\":0,\"ESC_ABSFailed\":1,\"ESC_AVH_Sts\":0,\"SRS_TimeoutFlag\":0,\"BMS_ContactorTempAve_Negative\":25,\"ICU_WashLiquidLevelWarn\":1,\"APA_Process_bar\":127,\"BMS_BatSOC_Rpt\":80.6,\"ESC_ReqEPB\":0,\"VCU_PCUFailSta\":0,\"GPS_Heading\":198.6,\"VCU_VehActlDrvMode\":1,\"BMS_HVBatActlVoltage\":383.7,\"DCC_ActlOprtMode\":2,\"BMS_MinTempProbeCod\":2,\"VCU_ActlMotorRotateSpdV\":1,\"VCU_CruiseCtrlSta\":0,\"BCM_DoorLockSta_FR_RL_RR\":1,\"VCU_MotorActualPowerType\":0,\"ESC_VehicleSpeed\":460.74375,\"AC_SeatHeatTemp_FR_Rsrv\":-40,\"BMS_BatteryOverVolWrning\":0,\"BMS_DisChargeInterlockSta\":1,\"FRM_ACCMode_HMI\":0,\"VCU_DrvRangeDistEst\":340,\"BMS_LowSOCWrning\":0,\"HU_AEB_EnableSw\":0,\"VCU_PwrCoolFanSpdDuty\":10,\"VCU_VacmPumpSta\":0,\"DSCU_GetMemSuccInd\":0,\"BCM_FstChrgLidLockSts\":0,\"ESC_ESPActiveSta\":0,\"VCU_LimpHomeSta\":0,\"SRS_PassSeatbeltBuckleValid\":0,\"BCM_AjarSta_Hood\":0,\"BCM_FuelLidSts\":1,\"BMS_BatSOH\":100,\"BMS_MaxVolCellCod\":21,\"BCM_FogLampSta_Front\":0,\"ESC_HHC_FailSta\":1,\"BCM_ChrgAjarSta_Slow\":1,\"BMS_MaxCellVol\":4280,\"BMS_SysFailSta\":0,\"AVM_LDWFuncSta\":0,\"TPMS_TireTempValue_FR\":6,\"BCM_FOB_NUM\":0,\"BMS_ESS_InletColanttargettemp\":30,\"BMS_ESS_outletColantActtemp\":13,\"VCU_DrvReq_MotorTorqV\":1,\"BCM_NozzleHeatSta\":0,\"VCU_VacuumPumError\":0,\"BMS_HVBatCellTempMax\":13,\"BAT_HVHFailSta\":0,\"EPB_WarnLampSta\":0,\"EPS_BasicElecSteerFailed\":0,\"SAS_Angle\":71.2,\"TPMS_TireTempValue_FL\":5,\"BCM_Warn_UID_LOW_BATT\":0,\"BMS_TempDifferWrning\":0,\"ICU_ICUTripBOdometer\":0,\"VCU_AtmosPressure\":945,\"AC_RefrgHiPressure\":300,\"ESC_HDC_WorkSts\":3,\"HU_HMA_EnableReq_Rsvr\":0,\"VCU_MCU_Temp\":26,\"ICU_drive_time\":0,\"BCM_DoorKnobSts\":0,\"AC_FailSta\":0,\"AC_OutAirQualityLevel\":12,\"BMS_ACChrgAtclSta\":1,\"APA_DrRqst\":0,\"IMMO_PCUauthen\":0,\"BCM_WiperCtrl_Front\":0,\"EGSM_FaultLevel\":3,\"HU_BSD_EnableSw\":0,\"FRM_TimeoutFlag\":0,\"BAT_HVHActlPwr\":0,\"HU_UIDSaveSuccessFb\":0,\"VCU_BrkPedalSnsrPosV_Reserved\":1,\"APA_Parkslot_State\":0,\"VCU_MCU_Input_Vol\":0,\"BCM_BeamLampOpenWarn\":0,\"BCM_RoofLampSts_FR\":0,\"ICU_DisplayVehicleSpeed\":0,\"BCM_RoofLampSts_FL\":0,\"BMS_AuxHeatReqPower_Reserved\":0,\"BMS_CellVolMax\":4.007,\"VCU_MotorDTC_Num\":0,\"VCU_ActlMotorRotateSpd\":0,\"BCM_FrontWashSts\":0,\"BMS_CellUnderrVolWrning\":0,\"EPB_ActuatorSt_L\":0,\"BMS_TempProbe\":[13,12,13,13,12,12,13,12,12,12,12,12,12,12,13,13,12,12,12,13,13,13,13,12,12,13,13,13,12,12,13,12,13,13,12,12,12,13,13,13,13,12,12,12,12,12,12,12],\"BMS_Contactor_state_ACCharger\":1,\"EPB_ActuatorSt_R\":0,\"BCM_RearWashSts\":0,\"TMPS_FailWarn\":0,\"AC_InAirPM25Value\":0,\"BAT_HighVolDCTolalPwr\":0,\"YRS_LateralAcce\":0,\"HU_FCW_EnableSw\":0,\"VCU_QECACC\":0,\"VCU_BrkPedalPos\":2.4,\"VCU_MCU_Input_Curr\":0,\"TBOX_EcallDispReq_Rsvd\":0,\"TBOX_BcallDispReq_Rsvd\":0,\"APA_TimeoutFlag\":0,\"VCU_MCUHighTempWrning\":0,\"AC_ION_EnaFb\":0,\"BCM_FuelLidLockSts\":0,\"TBOX_Abnmlvbrt\":0,\"BCM_PsgDoorHdlSwSts\":0,\"HU_EPS_ModReq\":0,\"HU_HighBeamSwCtrl\":0,\"BMS_ESS_CoolingPowEnb\":0,\"SAS_CalibSts\":1,\"BCM_DoorsLockLatchOverHeat\":0,\"VCU_ACCMOprtCmd\":0,\"BMS_BatterytSysMismatchingWrning\":0,\"AC_HVHDeviceInternTemp_HVAC\":0,\"BMS_DC_AC_RemChrgTime\":128,\"ESC_recupLevelStafedbk\":1,\"BMS_MaxConDisCurnt\":500,\"ESC_TimeoutFlag\":0,\"BMS_UnderVoltageStatus\":0,\"SRS_DrvSeatbeltBucklestatus\":0,\"HU_Fragrance_EnaSet\":0,\"HU_Phone_Calls\":0,\"NaviCurrentRoadType\":0,\"BCM_HazardLampSts\":0,\"BCM_DoorAjarSta_FL\":0,\"BCM_BrakePadelSta\":0,\"BCM_DoorAjarSta_FR\":0,\"NaviSpeedLimitStatus\":0,\"VCU_PCUWaterPumpSta\":1,\"VCU_12VBatLowVolSta\":0,\"BMS_MinVolCellCod\":17,\"AC_ActlOprtMode\":0,\"BMS_TimeoutFlag\":0,\"ESC_VhclStandstillSta\":2,\"BCM_FogLampSta_Rear\":0,\"VCU_Actl_MotorTorque\":0,\"ESC_NoBrakeForce\":0,\"TPMS_CtrlrSenserLearnSta\":2,\"AVM_SysOprtSta\":0,\"BMS_BatterySubSysNum\":1,\"HU_HDC_BtnSta\":0,\"BMS_AuxHeatOnReq_Reserved\":0,\"BMS_ChargeInterlockSta\":1,\"TBOX_UTC_Time\":1.543449088E9,\"HU_CentralLockSwCtrl\":0,\"BMS_PwrRecupMaxConChrgCurnt\":81.5,\"ESC_HBB_Intervention\":0,\"BMS_PwrRecupMaxInstanChrgCurnt\":103.5,\"HU_UID\":0,\"AC_EnvirTempV\":1,\"BCM_AutoLampStatus\":0,\"BMS_MaxAllowChrgVol_DC\":0,\"BMS_ESS_HeatingPowEnb\":1,\"AVM_BSDWarn_Right\":0,\"ICU_BrakeLiquidLevelWarn\":1,\"VCU_Actl_MotorRotateSpd\":0,\"OBC_TimeoutFlag\":0,\"YRS_LongitAcce\":0,\"SRS_AirbagWarningLampSts\":0,\"DCC_OverTemperatureFail\":0,\"SRS_PassengerAirbagSta_Rsvr\":1,\"BAT_PumpSpeedDutyRequest\":0,\"IMMO_TBOXAuthen\":0,\"BCM_TrunkDoorHdlSwSts\":0,\"BCM_Drv_wdw_Opend\":0,\"BMS_InsulationWrning\":0,\"VCU_PCUInletCooltTemp\":25,\"HU_FstChrgAjarSpd\":0,\"AVM_Camera_Left\":0,\"AVM_Camera_Right\":0,\"SrPosition\":3,\"SAS_RotSpeed\":0,\"HU_PeristalsisModeEnb\":0,\"AC_HVHFailSta_HVAC\":1,\"BMS_HighTempWrning\":0,\"BMS_CellVol\":[4,3.999,4.002,4,3.999,3.999,3.998,3.997,4.002,4.002,3.999,4.001,3.998,3.998,4.004,4,3.987,3.999,3.998,4.001,4.007,4.001,4.005,4.003,3.995,3.992,3.993,3.996,3.998,4.001,4.003,3.996,4.001,3.999,3.995,3.997,3.995,4,4,4.004,4.001,4.001,4.001,4.002,3.996,3.997,4,3.998,3.992,3.997,3.999,3.995,4.004,3.995,3.996,3.998,3.996,3.996,3.997,3.997,3.987,3.997,3.994,4,3.998,4,3.994,3.996,3.998,3.996,3.99,3.996,3.991,3.995,3.994,3.994,3.995,3.996,3.988,3.993,3.997,3.999,3.993,3.997,3.996,3.996,3.998,3.996,4.002,4.002,4,3.994,3.999,4,3.997,4],\"BCM_SysPwrMode\":0,\"TPMS_PressureSta_FR\":0,\"HU_TargetSOC\":0,\"BCM_HighBeamSta\":0,\"AVM_Camera_Front\":0,\"HU_ESCFuncEnaSta\":0,\"HU_LDW_WorkModeSw\":3,\"PTG_DoorOpenRatio\":0,\"TPMS_PressureSta_FL\":0,\"DCC_TimeoutFlag\":0,\"TPMS_TempSts_RL\":0,\"DCC_DeratingOprtSta\":0,\"TPMS_TempSts_RR\":0,\"BCM_TopLampModeFb\":1,\"BCM_HeavyRainInd\":0,\"BCM_RL_wdw_Opend\":0,\"HU_AVM_SVC_DisplaySta\":0,\"BCM_TrunkSwSts_Drv\":0,\"VCU_AntithftAuthRslt\":0,\"AVM_FuncSta\":0,\"HU_AVH_Enb\":0,\"BMS_ESS_InletColantActtemp\":13,\"BCM_StrWhlPwSpplSts\":0,\"BMS_Contactor_state_Positive\":1,\"BMS_HighSOCWrning\":0,\"OBC_ActlOprtMode\":2,\"VCU_VhclPwrCnsmpAvrg\":0,\"AC_Fragrance_EnaFb\":0,\"AC_SeatHeatTemp_FL_Rsrv\":-40,\"BCM_AjarStaV_Hood\":1,\"BMS_IsoResistance\":40.92,\"HU_ChrgSwSts\":0,\"BMS_MaxAllowChrgCur_DC\":0,\"BMS_MaxChrgVoltage_AC\":410.5,\"EPS_ModeSetInhibitFb\":0,\"TPMS_TireTempValue_RL\":4,\"GPS_Speed\":0,\"VCU_AcclPedalPosSnsrSta\":1,\"TPMS_TireTempValue_RR\":3,\"APA_Recover_INT_Indication\":0,\"VCU_HighVolInterlockSta\":1,\"YRS_YawRate\":0,\"BMS_HighVolInterLockWrning\":0,\"AC_IONWorkSta\":0,\"BMS_MaxCellTemp\":60,\"BMS_DCS_InletConnectSta\":0,\"GPS_Longitude\":116.742261,\"VCU_Actl_MotorTorqueV\":1,\"BMS_DCS_FailSta\":0,\"HU_ION_EnaSet\":0,\"VCU_MotorActualPower\":0,\"HU_TrctMdSwSet\":0,\"BMS_MinCellVol\":2800,\"BMS_DCS_ActlChrgCurrent\":0,\"YRS_YawRateSensorState\":1,\"BCM_ChildLockSta_RR\":0,\"APA_PrkgChc_Fdbk\":0,\"ESC_ABSActiveSta\":0,\"BCM_AjarSta_Trunk\":0,\"IMMOAuthenticRequest\":0,\"BCM_ChildLockSta_RL\":0,\"VCU_RmtVhclStartACWorkCmd\":0,\"AVM_BSDWarn_Left\":0,\"BMS_CellVolAve\":3.997,\"APA_Status\":0,\"BCM_SysPwrModeV\":1,\"BMS_ContactorTempAve_DCCharger\":11,\"BMS_MaxInstanDisCurnt\":500,\"ESC_BrakePedalSwV\":0,\"BCM_LowBeamSta\":0,\"VCU_BMS_Shutdown\":0,\"BMS_MaxTempProbeCod\":1,\"ESC_ESCFailed\":1,\"BCM_BodyWarnSts\":1,\"VCU_VacuumPressure\":595,\"ICU_ICUTotalOdometer\":2296.6,\"OBC_InletConnctSta\":1,\"BMS_CellOverVolWrning\":0,\"AVM_LDWWarn\":0,\"VCU_BOSFuncActv\":0,\"HU_TurnAssLampEnb\":0,\"ESC_TrgtGearReq\":7,\"BCM_DrvDoorHdlSwSts\":0,\"BMS_AbnormallSOCWrning\":0,\"EPB_TimeoutFlag\":1,\"BMS_ContactorTempAve_Positive\":215,\"TBOX_EPBRequest\":0,\"DSCU_FailSta\":0,\"TPMS_TempSts_FR\":0,\"YRS_LateralSensorState\":1,\"BMS_DCS_ActlChrgPower\":0,\"BCM_KEY_Forbidden\":0,\"SRS_PassSeatbeltBucklestatus\":1,\"TPMS_TempSts_FL\":0,\"SAS_FailureSts\":0,\"APA_DistToparkslot\":0,\"BMS_Contactor_state_DCCharger\":0,\"EPS_TimeoutFlag\":0,\"BMS_BatteryUnderrVolWrning\":0,\"AVM_BSDFuncSta\":0,\"BMS_MinCellTemp\":-30,\"NaviCountryCode\":0,\"TPMS_PressureValue_FL\":209,\"VCU_MotorTemp\":25,\"ESC_VehicleSpeedV\":0,\"SRS_SeatbeltBucklestatus_RR\":1,\"BCM_TurnLampSta_Left\":0,\"BMS_DCS_ChrgEnb\":0,\"SRS_SeatbeltBucklestatus_RM\":1,\"BCM_SlwChrgLidLockSts\":0,\"SRS_SeatbeltBucklestatus_RL\":1,\"TPMS_PressureValue_FR\":203.5,\"VCU_MotorHighTempWrning\":0,\"BCM_ChrgAjarSta_Fast\":0,\"AC_HVHActlOprtMode_HVAC\":0,\"APA_Indication\":0,\"BMS_BatteryDTC_Num\":0,\"BCM_TurnLampSta_Right\":0,\"BMS_DCS_ActOprtMode\":0,\"BMS_Heating_STS_Reserved\":0,\"TMPS_AbnmPrsrWarn\":0,\"VCU_VhclPwrCnsmpActl\":0,\"BMS_TotalCellNo\":96,\"YRS_LongitSensorState\":1,\"BMS_HVBatCellTempMinV\":1,\"BMS_BatteryOverChrgWrning\":0,\"BCM_SysPowerSts\":0,\"VCU_StrgRecupReqBrkLampOn\":0,\"ESC_TCSFailed\":1,\"VCU_MotorDTC_List\":[],\"BCM_DoorLockSta_FL\":1,\"BMS_BatteryType\":6,\"APA_Quit_Indication\":0,\"BMS_HVcppltnTempAve\":12,\"BMS_Prechargingsta\":2,\"BAT_HVHActlOprtState\":0,\"VCU_CruiseCtrTgtSpd\":0,\"BMS_Contactor_state_Negative\":1,\"OBC_SysFailSta\":0,\"VCU_DDModeSwSet\":0,\"BMS_HVBatActlVoltageV\":1,\"AC_EnvirTemp\":0,\"BCM_ReverseLampSta\":0,\"ESC_HBB_Sts\":3,\"BMS_MaxChrgCurrent_AC\":49.5,\"BMS_DCS_ActlChrgVoltage\":0,\"BCM_PTGUnlockCmd\":0,\"AC_HVHActlPwr_HVAC\":0,\"ICU_AverageVehicleSpeed\":0}";
        JSONObject result = JSONObject.parseObject(items);
        System.out.println(result);
        System.out.println(result.size());
    }

}