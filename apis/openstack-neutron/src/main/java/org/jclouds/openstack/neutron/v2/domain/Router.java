/**
 * Licensed to jclouds, Inc. (jclouds) under one or more
 * contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  jclouds licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package  org.jclouds.openstack.neutron.v2.domain;

import com.google.common.base.Objects;
import org.jclouds.javax.annotation.Nullable;

import javax.inject.Named;
import java.beans.ConstructorProperties;

/**
 * A Neutron Router
 *
 * @see <a
 *      href="http://docs.openstack.org/api/openstack-network/2.0/content/router_ext_concepts.html">api
 *      doc</a>
 */
public class Router {

   private String id;
   private NetworkStatus status;

   private String name;
   @Named("tenant_id")
   private String tenantId;
   @Named("admin_state_up")
   private Boolean adminStateUp;
   @Named("external_gateway_info")
   private ExternalGatewayInfo externalGatewayInfo;

   /**
    * @param id
    * @param status
    * @param name
    * @param tenantId
    * @param adminStateUp
    * @param externalGatewayInfo
    */
   @ConstructorProperties({"id", "status", "name", "tenant_id", "admin_state_up", "external_gateway_info"})
   private Router(String id, NetworkStatus status, String name, String tenantId, Boolean adminStateUp, ExternalGatewayInfo externalGatewayInfo) {
      this.id = id;
      this.status = status;
      this.name = name;
      this.tenantId = tenantId;
      this.adminStateUp = adminStateUp;
      this.externalGatewayInfo = externalGatewayInfo;
   }

   /**
    * Default constructor.
    */
   private Router() {}

   /**
    * Copy constructor
    * @param router
    */
   private Router(Router router) {
      this(router.id, router.status, router.name, router.tenantId, router.adminStateUp, router.externalGatewayInfo);
   }

   /**
    * @return the id of the Router
    */
   @Nullable
   public String getId() {
      return id;
   }

   /**
    * @return the status of the Router
    */
   @Nullable
   public NetworkStatus getStatus() {
      return status;
   }

   /**
    * @return the name of the Router
    */
   @Nullable
   public String getName() {
      return name;
   }

   /**
    * @return the tenantId of the Router
    */
   @Nullable
   public String getTenantId() {
      return tenantId;
   }

   /**
    * @return the adminStateUp of the Router
    */
   @Nullable
   public Boolean isAdminStateUp() {
      return adminStateUp;
   }

   /**
    * @return the externalGatewayInfo of the Router
    */
   @Nullable
   public ExternalGatewayInfo getExternalGatewayInfo() {
      return externalGatewayInfo;
   }

   /**
    * @return the Builder for creating a new Router
    */
   public static CreateBuilder createOptions() {
      return new CreateBuilder();
   }

   /**
    * @return the Builder for updating a Router
    */
   public static UpdateBuilder updateOptions() {
      return new UpdateBuilder();
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;

      Router that = (Router) o;

      return Objects.equal(this.id, that.id) &&
            Objects.equal(this.status, that.status) &&
            Objects.equal(this.name, that.name) &&
            Objects.equal(this.tenantId, that.tenantId) &&
            Objects.equal(this.adminStateUp, that.adminStateUp) &&
            Objects.equal(this.externalGatewayInfo, that.externalGatewayInfo);
   }

   @Override
   public int hashCode() {
      return Objects.hashCode(id, status, name, tenantId, adminStateUp, externalGatewayInfo);
   }

   @Override
   public String toString() {
      return Objects.toStringHelper(this)
            .add("id", id)
            .add("status", status)
            .add("name", name)
            .add("tenantId", tenantId)
            .add("adminStateUp", adminStateUp)
            .add("externalGatewayInfo", externalGatewayInfo)
            .toString();
   }

   private static abstract class Builder<ParameterizedBuilderType> {
      protected Router router;

      /**
       * No-parameters constructor used when updating.
       * */
      private Builder() {
         router = new Router();
      }

      protected abstract ParameterizedBuilderType self();

      /**
       * Provide the name to the Router's Builder.
       *
       * @return the Builder.
       * @see  org.jclouds.openstack.neutron.v2.domain.Router#getName()
       */
      public ParameterizedBuilderType name(String name) {
         router.name = name;
         return self();
      }

      /**
       * Provide the tenantId to the Router's Builder.
       *
       * @return the Builder.
       * @see  org.jclouds.openstack.neutron.v2.domain.Router#getTenantId()
       */
      public ParameterizedBuilderType tenantId(String tenantId) {
         router.tenantId = tenantId;
         return self();
      }

      /**
       * Provide the adminStateUp to the Router's Builder.
       *
       * @return the Builder.
       * @see  org.jclouds.openstack.neutron.v2.domain.Router#isAdminStateUp()
       */
      public ParameterizedBuilderType adminStateUp(boolean adminStateUp) {
         router.adminStateUp = adminStateUp;
         return self();
      }

      /**
       * Provide the externalGatewayInfo to the Router's Builder.
       *
       * @return the Builder.
       * @see  org.jclouds.openstack.neutron.v2.domain.Router#getExternalGatewayInfo()
       */
      public ParameterizedBuilderType externalGatewayInfo(ExternalGatewayInfo externalGatewayInfo) {
         router.externalGatewayInfo = externalGatewayInfo;
         return self();
      }
   }

   public static class CreateBuilder extends Builder<CreateBuilder> {
      /**
       * Supply required properties for creating a Builder
       */
      private CreateBuilder() {
      }

      /**
       * @return a CreateOptions constructed with this Builder.
       */
      public CreateOptions build() {
         return new CreateOptions(router);
      }

      protected CreateBuilder self() {
         return this;
      }
   }

   public static class UpdateBuilder extends Builder<UpdateBuilder> {
      /**
       * Supply required properties for updating a Builder
       */
      private UpdateBuilder() {
      }

      /**
       * @return a UpdateOptions constructed with this Builder.
       */
      public UpdateOptions build() {
         return new UpdateOptions(router);
      }

      protected UpdateBuilder self() {
         return this;
      }
   }

   public static class CreateOptions extends Router{
      /**
       * Copy constructor
       */
      private CreateOptions(Router router) {
         super(router);
      }
   }
   public static class UpdateOptions extends Router{
      /**
       * Copy constructor
       */
      private UpdateOptions(Router router) {
         super(router);
      }
   }
}
