package com.sysu.swfbackend.bean;

public class ProcessDefinitionBean {
    private String ID_;
    private int REV_;
    private String CATEGORY_;
    private String NAME_;
    private String KEY_;
    private int VERSION_;
    private String DEPLOYMENT_ID_;
    private String RESOURCE_NAME_;
    private String DGRAM_RESOURCE_NAME_;
    private String DESCRIPTION_;
    private int HAS_START_FORM_KEY_;
    private int HAS_GRAPHICAL_NOTATION_;
    private int SUSPENSION_STATE_;
    private String TENANT_ID_;
    private String ENGINE_VERSION_;

    public ProcessDefinitionBean() {
    }

    public ProcessDefinitionBean(String ID_, int REV_, String CATEGORY_, String NAME_, String KEY_, int VERSION_, String DEPLOYMENT_ID_, String RESOURCE_NAME_, String DGRAM_RESOURCE_NAME_, String DESCRIPTION_, int HAS_START_FORM_KEY_, int HAS_GRAPHICAL_NOTATION_, int SUSPENSION_STATE_, String TENANT_ID_, String ENGINE_VERSION_) {
        this.ID_ = ID_;
        this.REV_ = REV_;
        this.CATEGORY_ = CATEGORY_;
        this.NAME_ = NAME_;
        this.KEY_ = KEY_;
        this.VERSION_ = VERSION_;
        this.DEPLOYMENT_ID_ = DEPLOYMENT_ID_;
        this.RESOURCE_NAME_ = RESOURCE_NAME_;
        this.DGRAM_RESOURCE_NAME_ = DGRAM_RESOURCE_NAME_;
        this.DESCRIPTION_ = DESCRIPTION_;
        this.HAS_START_FORM_KEY_ = HAS_START_FORM_KEY_;
        this.HAS_GRAPHICAL_NOTATION_ = HAS_GRAPHICAL_NOTATION_;
        this.SUSPENSION_STATE_ = SUSPENSION_STATE_;
        this.TENANT_ID_ = TENANT_ID_;
        this.ENGINE_VERSION_ = ENGINE_VERSION_;
    }

    public String getID_() {
        return ID_;
    }

    public void setID_(String ID_) {
        this.ID_ = ID_;
    }

    public int getREV_() {
        return REV_;
    }

    public void setREV_(int REV_) {
        this.REV_ = REV_;
    }

    public String getCATEGORY_() {
        return CATEGORY_;
    }

    public void setCATEGORY_(String CATEGORY_) {
        this.CATEGORY_ = CATEGORY_;
    }

    public String getNAME_() {
        return NAME_;
    }

    public void setNAME_(String NAME_) {
        this.NAME_ = NAME_;
    }

    public String getKEY_() {
        return KEY_;
    }

    public void setKEY_(String KEY_) {
        this.KEY_ = KEY_;
    }

    public int getVERSION_() {
        return VERSION_;
    }

    public void setVERSION_(int VERSION_) {
        this.VERSION_ = VERSION_;
    }

    public String getDEPLOYMENT_ID_() {
        return DEPLOYMENT_ID_;
    }

    public void setDEPLOYMENT_ID_(String DEPLOYMENT_ID_) {
        this.DEPLOYMENT_ID_ = DEPLOYMENT_ID_;
    }

    public String getRESOURCE_NAME_() {
        return RESOURCE_NAME_;
    }

    public void setRESOURCE_NAME_(String RESOURCE_NAME_) {
        this.RESOURCE_NAME_ = RESOURCE_NAME_;
    }

    public String getDGRAM_RESOURCE_NAME_() {
        return DGRAM_RESOURCE_NAME_;
    }

    public void setDGRAM_RESOURCE_NAME_(String DGRAM_RESOURCE_NAME_) {
        this.DGRAM_RESOURCE_NAME_ = DGRAM_RESOURCE_NAME_;
    }

    public String getDESCRIPTION_() {
        return DESCRIPTION_;
    }

    public void setDESCRIPTION_(String DESCRIPTION_) {
        this.DESCRIPTION_ = DESCRIPTION_;
    }

    public int getHAS_START_FORM_KEY_() {
        return HAS_START_FORM_KEY_;
    }

    public void setHAS_START_FORM_KEY_(int HAS_START_FORM_KEY_) {
        this.HAS_START_FORM_KEY_ = HAS_START_FORM_KEY_;
    }

    public int getHAS_GRAPHICAL_NOTATION_() {
        return HAS_GRAPHICAL_NOTATION_;
    }

    public void setHAS_GRAPHICAL_NOTATION_(int HAS_GRAPHICAL_NOTATION_) {
        this.HAS_GRAPHICAL_NOTATION_ = HAS_GRAPHICAL_NOTATION_;
    }

    public int getSUSPENSION_STATE_() {
        return SUSPENSION_STATE_;
    }

    public void setSUSPENSION_STATE_(int SUSPENSION_STATE_) {
        this.SUSPENSION_STATE_ = SUSPENSION_STATE_;
    }

    public String getTENANT_ID_() {
        return TENANT_ID_;
    }

    public void setTENANT_ID_(String TENANT_ID_) {
        this.TENANT_ID_ = TENANT_ID_;
    }

    public String getENGINE_VERSION_() {
        return ENGINE_VERSION_;
    }

    public void setENGINE_VERSION_(String ENGINE_VERSION_) {
        this.ENGINE_VERSION_ = ENGINE_VERSION_;
    }
}
