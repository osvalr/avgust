package pe.com.acme.domain.mybatis.model;

import java.io.Serializable;
import java.util.Date;

public class MembInfo extends MembInfoKey implements Serializable {
    private String memb___id;

    private String memb__pwd;

    private String memb_name;

    private String sno__numb;

    private String post_code;

    private String addr_info;

    private String addr_deta;

    private String tel__numb;

    private String phon_numb;

    private String mail_addr;

    private String fpas_ques;

    private String fpas_answ;

    private String job__code;

    private Date appl_days;

    private Date modi_days;

    private Date out__days;

    private Date true_days;

    private String mail_chek;

    private String bloc_code;

    private String ctl1_code;

    private Integer cspoints;

    private Integer country;

    private Integer gender;

    private static final long serialVersionUID = 1L;

    public String getMemb___id() {
        return memb___id;
    }

    public void setMemb___id(String memb___id) {
        this.memb___id = memb___id;
    }

    public String getMemb__pwd() {
        return memb__pwd;
    }

    public void setMemb__pwd(String memb__pwd) {
        this.memb__pwd = memb__pwd;
    }

    public String getMemb_name() {
        return memb_name;
    }

    public void setMemb_name(String memb_name) {
        this.memb_name = memb_name;
    }

    public String getSno__numb() {
        return sno__numb;
    }

    public void setSno__numb(String sno__numb) {
        this.sno__numb = sno__numb;
    }

    public String getPost_code() {
        return post_code;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    public String getAddr_info() {
        return addr_info;
    }

    public void setAddr_info(String addr_info) {
        this.addr_info = addr_info;
    }

    public String getAddr_deta() {
        return addr_deta;
    }

    public void setAddr_deta(String addr_deta) {
        this.addr_deta = addr_deta;
    }

    public String getTel__numb() {
        return tel__numb;
    }

    public void setTel__numb(String tel__numb) {
        this.tel__numb = tel__numb;
    }

    public String getPhon_numb() {
        return phon_numb;
    }

    public void setPhon_numb(String phon_numb) {
        this.phon_numb = phon_numb;
    }

    public String getMail_addr() {
        return mail_addr;
    }

    public void setMail_addr(String mail_addr) {
        this.mail_addr = mail_addr;
    }

    public String getFpas_ques() {
        return fpas_ques;
    }

    public void setFpas_ques(String fpas_ques) {
        this.fpas_ques = fpas_ques;
    }

    public String getFpas_answ() {
        return fpas_answ;
    }

    public void setFpas_answ(String fpas_answ) {
        this.fpas_answ = fpas_answ;
    }

    public String getJob__code() {
        return job__code;
    }

    public void setJob__code(String job__code) {
        this.job__code = job__code;
    }

    public Date getAppl_days() {
        return appl_days;
    }

    public void setAppl_days(Date appl_days) {
        this.appl_days = appl_days;
    }

    public Date getModi_days() {
        return modi_days;
    }

    public void setModi_days(Date modi_days) {
        this.modi_days = modi_days;
    }

    public Date getOut__days() {
        return out__days;
    }

    public void setOut__days(Date out__days) {
        this.out__days = out__days;
    }

    public Date getTrue_days() {
        return true_days;
    }

    public void setTrue_days(Date true_days) {
        this.true_days = true_days;
    }

    public String getMail_chek() {
        return mail_chek;
    }

    public void setMail_chek(String mail_chek) {
        this.mail_chek = mail_chek;
    }

    public String getBloc_code() {
        return bloc_code;
    }

    public void setBloc_code(String bloc_code) {
        this.bloc_code = bloc_code;
    }

    public String getCtl1_code() {
        return ctl1_code;
    }

    public void setCtl1_code(String ctl1_code) {
        this.ctl1_code = ctl1_code;
    }

    public Integer getCspoints() {
        return cspoints;
    }

    public void setCspoints(Integer cspoints) {
        this.cspoints = cspoints;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", memb___id=").append(memb___id);
        sb.append(", memb__pwd=").append(memb__pwd);
        sb.append(", memb_name=").append(memb_name);
        sb.append(", sno__numb=").append(sno__numb);
        sb.append(", post_code=").append(post_code);
        sb.append(", addr_info=").append(addr_info);
        sb.append(", addr_deta=").append(addr_deta);
        sb.append(", tel__numb=").append(tel__numb);
        sb.append(", phon_numb=").append(phon_numb);
        sb.append(", mail_addr=").append(mail_addr);
        sb.append(", fpas_ques=").append(fpas_ques);
        sb.append(", fpas_answ=").append(fpas_answ);
        sb.append(", job__code=").append(job__code);
        sb.append(", appl_days=").append(appl_days);
        sb.append(", modi_days=").append(modi_days);
        sb.append(", out__days=").append(out__days);
        sb.append(", true_days=").append(true_days);
        sb.append(", mail_chek=").append(mail_chek);
        sb.append(", bloc_code=").append(bloc_code);
        sb.append(", ctl1_code=").append(ctl1_code);
        sb.append(", cspoints=").append(cspoints);
        sb.append(", country=").append(country);
        sb.append(", gender=").append(gender);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}