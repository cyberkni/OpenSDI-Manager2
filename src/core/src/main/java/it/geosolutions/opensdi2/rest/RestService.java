/**
 * 
 */
package it.geosolutions.opensdi2.rest;

import it.geosolutions.opensdi2.configurations.model.OSDIConfigurationKVP;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author alessio.fabiani
 * 
 */
@JsonInclude(Include.NON_NULL)
public abstract class RestService {

    private boolean inited;
    
    private String serviceId;

    private String name;

    private String description;

    private String version;

    private String activeStatus;

    private List<RestItemParameter> parameters;

    /**
     * @param serviceId
     * @param description
     * @param version
     * @param activeStatus
     */
    @JsonCreator
    public RestService(String serviceId, String name, String description, String version,
            String activeStatus) {
        this.inited = false;
        this.serviceId = serviceId;
        this.name = name;
        this.description = description;
        this.version = version;
        this.activeStatus = activeStatus;
    }

    /**
     * @return the inited
     */
    public boolean isInited() {
        return inited;
    }

    /**
     * @param inited the inited to set
     */
    public void setInited(boolean inited) {
        this.inited = inited;
    }

    /**
     * 
     * @return
     */
    public String getServiceId() {
        return serviceId;
    }

    /**
     * 
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @return
     */
    public String getVersion() {
        return version;
    }

    /**
     * 
     * @return
     */
    public String getActiveStatus() {
        return activeStatus;
    }

    /**
     * @param activeStatus the activeStatus to set
     */
    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    /**
     * 
     * @return
     */
    public List<RestItemParameter> getParameters() {
        return parameters;
    }

    /**
     * 
     * @param parameters
     */
    public void setParameters(List<RestItemParameter> parameters) {
        this.parameters = parameters;
    }

    @JsonIgnore
    public abstract boolean loadConfiguration(OSDIConfigurationKVP osdiConfigurationKVP);

    @JsonIgnore
    public abstract List<RestServiceRuntime> getRuntimes(Principal auth) throws Exception;

    @JsonIgnore
    public abstract String execute(Principal auth, String requestBody, Map<String, String> params)
            throws Exception;

    @JsonIgnore
    public abstract String stop(Principal auth, RestServiceRuntime runtime,
            Map<String, String> params) throws Exception;

    @JsonIgnore
    public abstract boolean supportsQueries(Principal auth);

    // @JsonIgnore public abstract List<RestServiceInfoParam> getInputs();

    // @JsonIgnore public abstract List<RestServiceInfoParam> getOutputs();

    @JsonIgnore
    public abstract int countRuntimes(Principal auth);

    @JsonIgnore
    public abstract List<RestServiceRuntime> findRuntimes(Principal auth, String id, String status,
            Date startDate, Date endDate, Map<String, String> params, int page, int pageSize);

    @JsonIgnore
    public abstract RestServiceRuntime getRuntime(Principal auth, String id);

}