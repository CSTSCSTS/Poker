package com.example.demo.dbflute.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.dbflute.Entity;
import org.dbflute.dbmeta.DBMeta;
import org.dbflute.dbmeta.AbstractEntity;
import org.dbflute.dbmeta.accessory.DomainEntity;
import org.dbflute.optional.OptionalEntity;
import com.example.demo.dbflute.allcommon.DBMetaInstanceHandler;
import com.example.demo.dbflute.exentity.*;

/**
 * The entity of POKER_USER_INFO as TABLE. <br>
 * ポーカーユーザー情報
 * <pre>
 * [primary-key]
 *     USER_ID
 *
 * [column]
 *     USER_ID, USER_NAME, PASSWORD, LOGIN_DATE
 *
 * [sequence]
 *     POKER_USER_ID_SEQ1
 *
 * [identity]
 *     
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     POSSESSION_MONEY(AsOne)
 *
 * [referrer table]
 *     POSSESSION_MONEY
 *
 * [foreign property]
 *     possessionMoneyAsOne
 *
 * [referrer property]
 *     
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Integer userId = entity.getUserId();
 * String userName = entity.getUserName();
 * String password = entity.getPassword();
 * java.time.LocalDateTime loginDate = entity.getLoginDate();
 * entity.setUserId(userId);
 * entity.setUserName(userName);
 * entity.setPassword(password);
 * entity.setLoginDate(loginDate);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsPokerUserInfo extends AbstractEntity implements DomainEntity {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** USER_ID: {PK, NotNull, INTEGER(10), default=[NEXTVAL('POKER_USER_ID_SEQ1')]} */
    protected Integer _userId;

    /** USER_NAME: {UQ, NotNull, VARCHAR(255)} */
    protected String _userName;

    /** PASSWORD: {NotNull, VARCHAR(255)} */
    protected String _password;

    /** LOGIN_DATE: {TIMESTAMP(26, 6)} */
    protected java.time.LocalDateTime _loginDate;

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    /** {@inheritDoc} */
    public DBMeta asDBMeta() {
        return DBMetaInstanceHandler.findDBMeta(asTableDbName());
    }

    /** {@inheritDoc} */
    public String asTableDbName() {
        return "POKER_USER_INFO";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_userId == null) { return false; }
        return true;
    }

    /**
     * To be unique by the unique column. <br>
     * You can update the entity by the key when entity update (NOT batch update).
     * @param userName : UQ, NotNull, VARCHAR(255). (NotNull)
     */
    public void uniqueBy(String userName) {
        __uniqueDrivenProperties.clear();
        __uniqueDrivenProperties.addPropertyName("userName");
        setUserName(userName);
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    /** POSSESSION_MONEY by USER_ID, named 'possessionMoneyAsOne'. */
    protected OptionalEntity<PossessionMoney> _possessionMoneyAsOne;

    /**
     * [get] POSSESSION_MONEY by USER_ID, named 'possessionMoneyAsOne'.
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return the entity of foreign property(referrer-as-one) 'possessionMoneyAsOne'. (NotNull, EmptyAllowed: when e.g. no data, no setupSelect)
     */
    public OptionalEntity<PossessionMoney> getPossessionMoneyAsOne() {
        if (_possessionMoneyAsOne == null) { _possessionMoneyAsOne = OptionalEntity.relationEmpty(this, "possessionMoneyAsOne"); }
        return _possessionMoneyAsOne;
    }

    /**
     * [set] POSSESSION_MONEY by USER_ID, named 'possessionMoneyAsOne'.
     * @param possessionMoneyAsOne The entity of foreign property(referrer-as-one) 'possessionMoneyAsOne'. (NullAllowed)
     */
    public void setPossessionMoneyAsOne(OptionalEntity<PossessionMoney> possessionMoneyAsOne) {
        _possessionMoneyAsOne = possessionMoneyAsOne;
    }

    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    protected <ELEMENT> List<ELEMENT> newReferrerList() { // overriding to import
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsPokerUserInfo) {
            BsPokerUserInfo other = (BsPokerUserInfo)obj;
            if (!xSV(_userId, other._userId)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _userId);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_possessionMoneyAsOne != null && _possessionMoneyAsOne.isPresent())
        { sb.append(li).append(xbRDS(_possessionMoneyAsOne, "possessionMoneyAsOne")); }
        return sb.toString();
    }
    protected <ET extends Entity> String xbRDS(org.dbflute.optional.OptionalEntity<ET> et, String name) { // buildRelationDisplayString()
        return et.get().buildDisplayString(name, true, true);
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_userId));
        sb.append(dm).append(xfND(_userName));
        sb.append(dm).append(xfND(_password));
        sb.append(dm).append(xfND(_loginDate));
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    @Override
    protected String doBuildRelationString(String dm) {
        StringBuilder sb = new StringBuilder();
        if (_possessionMoneyAsOne != null && _possessionMoneyAsOne.isPresent())
        { sb.append(dm).append("possessionMoneyAsOne"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public PokerUserInfo clone() {
        return (PokerUserInfo)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] USER_ID: {PK, NotNull, INTEGER(10), default=[NEXTVAL('POKER_USER_ID_SEQ1')]} <br>
     * ユーザーID
     * @return The value of the column 'USER_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getUserId() {
        checkSpecifiedProperty("userId");
        return _userId;
    }

    /**
     * [set] USER_ID: {PK, NotNull, INTEGER(10), default=[NEXTVAL('POKER_USER_ID_SEQ1')]} <br>
     * ユーザーID
     * @param userId The value of the column 'USER_ID'. (basically NotNull if update: for the constraint)
     */
    public void setUserId(Integer userId) {
        registerModifiedProperty("userId");
        _userId = userId;
    }

    /**
     * [get] USER_NAME: {UQ, NotNull, VARCHAR(255)} <br>
     * ユーザー名
     * @return The value of the column 'USER_NAME'. (basically NotNull if selected: for the constraint)
     */
    public String getUserName() {
        checkSpecifiedProperty("userName");
        return _userName;
    }

    /**
     * [set] USER_NAME: {UQ, NotNull, VARCHAR(255)} <br>
     * ユーザー名
     * @param userName The value of the column 'USER_NAME'. (basically NotNull if update: for the constraint)
     */
    public void setUserName(String userName) {
        registerModifiedProperty("userName");
        _userName = userName;
    }

    /**
     * [get] PASSWORD: {NotNull, VARCHAR(255)} <br>
     * パスワード
     * @return The value of the column 'PASSWORD'. (basically NotNull if selected: for the constraint)
     */
    public String getPassword() {
        checkSpecifiedProperty("password");
        return _password;
    }

    /**
     * [set] PASSWORD: {NotNull, VARCHAR(255)} <br>
     * パスワード
     * @param password The value of the column 'PASSWORD'. (basically NotNull if update: for the constraint)
     */
    public void setPassword(String password) {
        registerModifiedProperty("password");
        _password = password;
    }

    /**
     * [get] LOGIN_DATE: {TIMESTAMP(26, 6)} <br>
     * ログイン日時
     * @return The value of the column 'LOGIN_DATE'. (NullAllowed even if selected: for no constraint)
     */
    public java.time.LocalDateTime getLoginDate() {
        checkSpecifiedProperty("loginDate");
        return _loginDate;
    }

    /**
     * [set] LOGIN_DATE: {TIMESTAMP(26, 6)} <br>
     * ログイン日時
     * @param loginDate The value of the column 'LOGIN_DATE'. (NullAllowed: null update allowed for no constraint)
     */
    public void setLoginDate(java.time.LocalDateTime loginDate) {
        registerModifiedProperty("loginDate");
        _loginDate = loginDate;
    }
}
