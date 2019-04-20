package api

// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is regenerated.

import (
    "context"
    "go"
    "github.com/Azure/go-autorest/autorest"
)

        // BaseClientAPI contains the set of methods on the BaseClient type.
        type BaseClientAPI interface {
            CreateBatchMethod(ctx context.Context, input .BatchType) (result .SetObjectType, err error)
            CreateConnectionMethod(ctx context.Context, input .ConnectionType) (result .SetObjectType, err error)
            CreateFlowMethod(ctx context.Context, input .FlowType) (result .SetObjectType, err error)
            CreateJobMethod(ctx context.Context, input .JobType) (result .SetObjectType, err error)
            CreateSchemaMethod(ctx context.Context, input .SchemaType) (result .SetObjectType, err error)
            CreateSchemaProfileMethod(ctx context.Context, input .SchemaProfileType) (result .SetObjectType, err error)
            CreateShapeMethod(ctx context.Context, input .ShapeType) (result .SetObjectType, err error)
            DeleteBatchMethod(ctx context.Context, ID string) (result autorest.Response, err error)
            DeleteConnectionMethod(ctx context.Context, ID string) (result autorest.Response, err error)
            DeleteFlowMethod(ctx context.Context, ID string) (result autorest.Response, err error)
            DeleteJobMethod(ctx context.Context, ID string) (result autorest.Response, err error)
            DeleteSchemaMethod(ctx context.Context, ID string) (result autorest.Response, err error)
            DeleteSchemaProfileMethod(ctx context.Context, ID string) (result autorest.Response, err error)
            DeleteShapeMethod(ctx context.Context, ID string) (result autorest.Response, err error)
            EventsPlaceholderForBatchMethod(ctx context.Context) (result .DataflowEventType, err error)
            EventsPlaceholderForJobMethod(ctx context.Context) (result .DataflowEventType, err error)
            GetAllBatchesMethod(ctx context.Context, ID string, name string, description string, jobID string, createdBy string, updatedBy string, deletedBy string) (result .ListBatchType, err error)
            GetAllConnectionsMethod(ctx context.Context, ID string, name string, description string, plugin string, preferredAgent string, createdBy string, updatedBy string, deletedBy string) (result .ListConnectionType, err error)
            GetAllFlowsMethod(ctx context.Context, ID string, name string, description string, createdBy string, updatedBy string, deletedBy string) (result .ListFlowType, err error)
            GetAllJobsMethod(ctx context.Context, ID string, name string, description string, connectionID string, schemaID string, shapeID string, agentID string, typeParameter string, createdBy string, updatedBy string, deletedBy string) (result .ListJobType, err error)
            GetAllSchemaProfilesMethod(ctx context.Context, ID string, name string, description string, connectionID string, createdBy string, updatedBy string, deletedBy string) (result .ListSchemaProfileType, err error)
            GetAllSchemasMethod(ctx context.Context, ID string, name string, description string, discoveredID string, discoveredName string, discoveredDescription string, query string, connectionID string, profilingJobID string, publisherMetaJSON string, capability string, createdBy string, updatedBy string, deletedBy string) (result .ListSchemaType, err error)
            GetAllShapesMethod(ctx context.Context, ID string, name string, description string, copiedFromSchemaID string, createdBy string, updatedBy string, deletedBy string) (result .ListShapeType, err error)
            GetBatchVersionsMethod(ctx context.Context, ID string) (result .ListBatchType, err error)
            GetConnectionVersionsMethod(ctx context.Context, ID string) (result .ListConnectionType, err error)
            GetFlowVersionsMethod(ctx context.Context, ID string) (result .ListFlowType, err error)
            GetJobMappingMethod(ctx context.Context, ID string, version *int32) (result .MappingType, err error)
            GetJobVersionsMethod(ctx context.Context, ID string) (result .ListJobType, err error)
            GetOneBatchMethod(ctx context.Context, ID string, version *int32) (result .BatchType, err error)
            GetOneConnectionMethod(ctx context.Context, ID string, version *int32) (result .ConnectionType, err error)
            GetOneFlowMethod(ctx context.Context, ID string, version *int32) (result .FlowType, err error)
            GetOneJobMethod(ctx context.Context, ID string, version *int32) (result .JobType, err error)
            GetOneSchemaMethod(ctx context.Context, ID string, version *int32) (result .SchemaType, err error)
            GetOneSchemaProfileMethod(ctx context.Context, ID string, version *int32) (result .SchemaProfileType, err error)
            GetOneShapeMethod(ctx context.Context, ID string, version *int32) (result .ShapeType, err error)
            GetPagedStatusesForBatchMethod(ctx context.Context, ID string, page *int32, pageSize *int32) (result .PagedResultOfBatchStatusType, err error)
            GetPagedStatusesForJobMethod(ctx context.Context, ID string, page *int32, pageSize *int32) (result .PagedResultOfJobStatusType, err error)
            GetSchemaProfileVersionsMethod(ctx context.Context, ID string) (result .ListSchemaProfileType, err error)
            GetSchemaVersionsMethod(ctx context.Context, ID string) (result .ListSchemaType, err error)
            GetShapeVersionsMethod(ctx context.Context, ID string) (result .ListShapeType, err error)
            SetBatchStatusForGoBetweenBatchMethod(ctx context.Context, ID string, status .BatchStatusGoBetweenScopeType) (result .SetListStringType, err error)
            SetJobStatusForGoBetweenMethod(ctx context.Context, ID string, status .JobStatusGoBetweenScopeType) (result .SetListStringType, err error)
            SetRealTimeStateMethod(ctx context.Context, ID string, state .RealTimeStateScopeType) (result .SetListStringType, err error)
            UpdateBatchMethod(ctx context.Context, ID string, model .BatchType) (result .SetObjectType, err error)
            UpdateConnectionMethod(ctx context.Context, ID string, model .ConnectionType) (result .SetObjectType, err error)
            UpdateFlowMethod(ctx context.Context, ID string, model .FlowType) (result .SetObjectType, err error)
            UpdateJobMethod(ctx context.Context, ID string, model .JobType) (result .SetObjectType, err error)
            UpdateSchemaMethod(ctx context.Context, ID string, model .SchemaType) (result .SetObjectType, err error)
            UpdateSchemaProfileMethod(ctx context.Context, ID string, model .SchemaProfileType) (result .SetObjectType, err error)
            UpdateShapeMethod(ctx context.Context, ID string, model .ShapeType) (result .SetObjectType, err error)
        }

        var _ BaseClientAPI = (*.BaseClient)(nil)
