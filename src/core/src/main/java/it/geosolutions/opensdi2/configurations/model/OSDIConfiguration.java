/*
 *  Copyright (C) 2007-2012 GeoSolutions S.A.S.
 *  http://www.geo-solutions.it
 *
 *  GPLv3 + Classpath exception
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package it.geosolutions.opensdi2.configurations.model;

/**
 * This interface define the basics methods for an OSDIConfiguration bean  
 * 
 * @author DamianoG
 * 
 */
public interface OSDIConfiguration {

    /**
     * It returns the scope identification ID of this configuration.
     *   
     * @param scopeID the identification ID of an OpenSDI module
     */
    public String getScopeID();
    
    /**
     * It returns the instance identification ID of this configuration within a certain scope.
     * 
     * @param instanceID the identification ID of an OpenSDI service instance
     */
    public String getInstanceID();
    
    /**
     * Ensure that the scopeID and instanceID provided are both not null, not empty and not whithespace
     * 
     * @return
     */
    public boolean validateIDs();
    
}
