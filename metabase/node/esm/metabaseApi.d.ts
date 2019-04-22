import * as msRest from "@azure/ms-rest-js";
import * as Models from "./models";
import * as Mappers from "./models/mappers";
import { MetabaseApiContext } from "./metabaseApiContext";
declare class MetabaseApi extends MetabaseApiContext {
    /**
     * Initializes a new instance of the MetabaseApi class.
     * @param credentials Subscription credentials which uniquely identify client subscription.
     * @param [options] The parameter options
     */
    constructor(credentials: msRest.ServiceClientCredentials, options?: Models.MetabaseApiOptions);
    /**
     * @summary Set batch status for go between batch.
     * @param id
     * @param status
     * @param [options] The optional parameters
     * @returns Promise<Models.SetBatchStatusForGoBetweenBatchResponse>
     */
    setBatchStatusForGoBetweenBatch(id: string, status: Models.BatchStatusGoBetweenScope, options?: msRest.RequestOptionsBase): Promise<Models.SetBatchStatusForGoBetweenBatchResponse>;
    /**
     * @param id
     * @param status
     * @param callback The callback
     */
    setBatchStatusForGoBetweenBatch(id: string, status: Models.BatchStatusGoBetweenScope, callback: msRest.ServiceCallback<{
        [propertyName: string]: string[];
    }>): void;
    /**
     * @param id
     * @param status
     * @param options The optional parameters
     * @param callback The callback
     */
    setBatchStatusForGoBetweenBatch(id: string, status: Models.BatchStatusGoBetweenScope, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<{
        [propertyName: string]: string[];
    }>): void;
    /**
     * @summary Get paged statuses for batch.
     * @param id
     * @param [options] The optional parameters
     * @returns Promise<Models.GetPagedStatusesForBatchResponse>
     */
    getPagedStatusesForBatch(id: string, options?: Models.MetabaseApiGetPagedStatusesForBatchOptionalParams): Promise<Models.GetPagedStatusesForBatchResponse>;
    /**
     * @param id
     * @param callback The callback
     */
    getPagedStatusesForBatch(id: string, callback: msRest.ServiceCallback<Models.PagedResultOfBatchStatus>): void;
    /**
     * @param id
     * @param options The optional parameters
     * @param callback The callback
     */
    getPagedStatusesForBatch(id: string, options: Models.MetabaseApiGetPagedStatusesForBatchOptionalParams, callback: msRest.ServiceCallback<Models.PagedResultOfBatchStatus>): void;
    /**
     * @summary Events placeholder for batch.
     * @param [options] The optional parameters
     * @returns Promise<Models.EventsPlaceholderForBatchResponse>
     */
    eventsPlaceholderForBatch(options?: msRest.RequestOptionsBase): Promise<Models.EventsPlaceholderForBatchResponse>;
    /**
     * @param callback The callback
     */
    eventsPlaceholderForBatch(callback: msRest.ServiceCallback<Models.DataflowEvent>): void;
    /**
     * @param options The optional parameters
     * @param callback The callback
     */
    eventsPlaceholderForBatch(options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<Models.DataflowEvent>): void;
    /**
     * @summary Get all batches.
     * @param [options] The optional parameters
     * @returns Promise<Models.GetAllBatchesResponse>
     */
    getAllBatches(options?: Models.MetabaseApiGetAllBatchesOptionalParams): Promise<Models.GetAllBatchesResponse>;
    /**
     * @param callback The callback
     */
    getAllBatches(callback: msRest.ServiceCallback<Models.Batch[]>): void;
    /**
     * @param options The optional parameters
     * @param callback The callback
     */
    getAllBatches(options: Models.MetabaseApiGetAllBatchesOptionalParams, callback: msRest.ServiceCallback<Models.Batch[]>): void;
    /**
     * @summary Create batch.
     * @param input
     * @param [options] The optional parameters
     * @returns Promise<Models.CreateBatchResponse>
     */
    createBatch(input: Models.Batch, options?: msRest.RequestOptionsBase): Promise<Models.CreateBatchResponse>;
    /**
     * @param input
     * @param callback The callback
     */
    createBatch(input: Models.Batch, callback: msRest.ServiceCallback<any>): void;
    /**
     * @param input
     * @param options The optional parameters
     * @param callback The callback
     */
    createBatch(input: Models.Batch, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<any>): void;
    /**
     * @summary Get one batch.
     * @param id
     * @param [options] The optional parameters
     * @returns Promise<Models.GetOneBatchResponse>
     */
    getOneBatch(id: string, options?: Models.MetabaseApiGetOneBatchOptionalParams): Promise<Models.GetOneBatchResponse>;
    /**
     * @param id
     * @param callback The callback
     */
    getOneBatch(id: string, callback: msRest.ServiceCallback<Models.Batch>): void;
    /**
     * @param id
     * @param options The optional parameters
     * @param callback The callback
     */
    getOneBatch(id: string, options: Models.MetabaseApiGetOneBatchOptionalParams, callback: msRest.ServiceCallback<Models.Batch>): void;
    /**
     * @summary Update batch.
     * @param id
     * @param model
     * @param [options] The optional parameters
     * @returns Promise<Models.UpdateBatchResponse>
     */
    updateBatch(id: string, model: Models.Batch, options?: msRest.RequestOptionsBase): Promise<Models.UpdateBatchResponse>;
    /**
     * @param id
     * @param model
     * @param callback The callback
     */
    updateBatch(id: string, model: Models.Batch, callback: msRest.ServiceCallback<any>): void;
    /**
     * @param id
     * @param model
     * @param options The optional parameters
     * @param callback The callback
     */
    updateBatch(id: string, model: Models.Batch, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<any>): void;
    /**
     * @summary Delete batch.
     * @param id
     * @param [options] The optional parameters
     * @returns Promise<msRest.RestResponse>
     */
    deleteBatch(id: string, options?: msRest.RequestOptionsBase): Promise<msRest.RestResponse>;
    /**
     * @param id
     * @param callback The callback
     */
    deleteBatch(id: string, callback: msRest.ServiceCallback<void>): void;
    /**
     * @param id
     * @param options The optional parameters
     * @param callback The callback
     */
    deleteBatch(id: string, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<void>): void;
    /**
     * @summary Get batch versions.
     * @param id
     * @param [options] The optional parameters
     * @returns Promise<Models.GetBatchVersionsResponse>
     */
    getBatchVersions(id: string, options?: msRest.RequestOptionsBase): Promise<Models.GetBatchVersionsResponse>;
    /**
     * @param id
     * @param callback The callback
     */
    getBatchVersions(id: string, callback: msRest.ServiceCallback<Models.Batch[]>): void;
    /**
     * @param id
     * @param options The optional parameters
     * @param callback The callback
     */
    getBatchVersions(id: string, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<Models.Batch[]>): void;
    /**
     * @summary Get all connections.
     * @param [options] The optional parameters
     * @returns Promise<Models.GetAllConnectionsResponse>
     */
    getAllConnections(options?: Models.MetabaseApiGetAllConnectionsOptionalParams): Promise<Models.GetAllConnectionsResponse>;
    /**
     * @param callback The callback
     */
    getAllConnections(callback: msRest.ServiceCallback<Models.Connection[]>): void;
    /**
     * @param options The optional parameters
     * @param callback The callback
     */
    getAllConnections(options: Models.MetabaseApiGetAllConnectionsOptionalParams, callback: msRest.ServiceCallback<Models.Connection[]>): void;
    /**
     * @summary Create connection.
     * @param input
     * @param [options] The optional parameters
     * @returns Promise<Models.CreateConnectionResponse>
     */
    createConnection(input: Models.Connection, options?: msRest.RequestOptionsBase): Promise<Models.CreateConnectionResponse>;
    /**
     * @param input
     * @param callback The callback
     */
    createConnection(input: Models.Connection, callback: msRest.ServiceCallback<any>): void;
    /**
     * @param input
     * @param options The optional parameters
     * @param callback The callback
     */
    createConnection(input: Models.Connection, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<any>): void;
    /**
     * @summary Get one connection.
     * @param id
     * @param [options] The optional parameters
     * @returns Promise<Models.GetOneConnectionResponse>
     */
    getOneConnection(id: string, options?: Models.MetabaseApiGetOneConnectionOptionalParams): Promise<Models.GetOneConnectionResponse>;
    /**
     * @param id
     * @param callback The callback
     */
    getOneConnection(id: string, callback: msRest.ServiceCallback<Models.Connection>): void;
    /**
     * @param id
     * @param options The optional parameters
     * @param callback The callback
     */
    getOneConnection(id: string, options: Models.MetabaseApiGetOneConnectionOptionalParams, callback: msRest.ServiceCallback<Models.Connection>): void;
    /**
     * @summary Update connection.
     * @param id
     * @param model
     * @param [options] The optional parameters
     * @returns Promise<Models.UpdateConnectionResponse>
     */
    updateConnection(id: string, model: Models.Connection, options?: msRest.RequestOptionsBase): Promise<Models.UpdateConnectionResponse>;
    /**
     * @param id
     * @param model
     * @param callback The callback
     */
    updateConnection(id: string, model: Models.Connection, callback: msRest.ServiceCallback<any>): void;
    /**
     * @param id
     * @param model
     * @param options The optional parameters
     * @param callback The callback
     */
    updateConnection(id: string, model: Models.Connection, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<any>): void;
    /**
     * @summary Delete connection.
     * @param id
     * @param [options] The optional parameters
     * @returns Promise<msRest.RestResponse>
     */
    deleteConnection(id: string, options?: msRest.RequestOptionsBase): Promise<msRest.RestResponse>;
    /**
     * @param id
     * @param callback The callback
     */
    deleteConnection(id: string, callback: msRest.ServiceCallback<void>): void;
    /**
     * @param id
     * @param options The optional parameters
     * @param callback The callback
     */
    deleteConnection(id: string, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<void>): void;
    /**
     * @summary Get connection versions.
     * @param id
     * @param [options] The optional parameters
     * @returns Promise<Models.GetConnectionVersionsResponse>
     */
    getConnectionVersions(id: string, options?: msRest.RequestOptionsBase): Promise<Models.GetConnectionVersionsResponse>;
    /**
     * @param id
     * @param callback The callback
     */
    getConnectionVersions(id: string, callback: msRest.ServiceCallback<Models.Connection[]>): void;
    /**
     * @param id
     * @param options The optional parameters
     * @param callback The callback
     */
    getConnectionVersions(id: string, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<Models.Connection[]>): void;
    /**
     * @summary Get all flows.
     * @param [options] The optional parameters
     * @returns Promise<Models.GetAllFlowsResponse>
     */
    getAllFlows(options?: Models.MetabaseApiGetAllFlowsOptionalParams): Promise<Models.GetAllFlowsResponse>;
    /**
     * @param callback The callback
     */
    getAllFlows(callback: msRest.ServiceCallback<Models.Flow[]>): void;
    /**
     * @param options The optional parameters
     * @param callback The callback
     */
    getAllFlows(options: Models.MetabaseApiGetAllFlowsOptionalParams, callback: msRest.ServiceCallback<Models.Flow[]>): void;
    /**
     * @summary Create flow.
     * @param input
     * @param [options] The optional parameters
     * @returns Promise<Models.CreateFlowResponse>
     */
    createFlow(input: Models.Flow, options?: msRest.RequestOptionsBase): Promise<Models.CreateFlowResponse>;
    /**
     * @param input
     * @param callback The callback
     */
    createFlow(input: Models.Flow, callback: msRest.ServiceCallback<any>): void;
    /**
     * @param input
     * @param options The optional parameters
     * @param callback The callback
     */
    createFlow(input: Models.Flow, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<any>): void;
    /**
     * @summary Get one flow.
     * @param id
     * @param [options] The optional parameters
     * @returns Promise<Models.GetOneFlowResponse>
     */
    getOneFlow(id: string, options?: Models.MetabaseApiGetOneFlowOptionalParams): Promise<Models.GetOneFlowResponse>;
    /**
     * @param id
     * @param callback The callback
     */
    getOneFlow(id: string, callback: msRest.ServiceCallback<Models.Flow>): void;
    /**
     * @param id
     * @param options The optional parameters
     * @param callback The callback
     */
    getOneFlow(id: string, options: Models.MetabaseApiGetOneFlowOptionalParams, callback: msRest.ServiceCallback<Models.Flow>): void;
    /**
     * @summary Update flow.
     * @param id
     * @param model
     * @param [options] The optional parameters
     * @returns Promise<Models.UpdateFlowResponse>
     */
    updateFlow(id: string, model: Models.Flow, options?: msRest.RequestOptionsBase): Promise<Models.UpdateFlowResponse>;
    /**
     * @param id
     * @param model
     * @param callback The callback
     */
    updateFlow(id: string, model: Models.Flow, callback: msRest.ServiceCallback<any>): void;
    /**
     * @param id
     * @param model
     * @param options The optional parameters
     * @param callback The callback
     */
    updateFlow(id: string, model: Models.Flow, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<any>): void;
    /**
     * @summary Delete flow.
     * @param id
     * @param [options] The optional parameters
     * @returns Promise<msRest.RestResponse>
     */
    deleteFlow(id: string, options?: msRest.RequestOptionsBase): Promise<msRest.RestResponse>;
    /**
     * @param id
     * @param callback The callback
     */
    deleteFlow(id: string, callback: msRest.ServiceCallback<void>): void;
    /**
     * @param id
     * @param options The optional parameters
     * @param callback The callback
     */
    deleteFlow(id: string, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<void>): void;
    /**
     * @summary Get flow versions.
     * @param id
     * @param [options] The optional parameters
     * @returns Promise<Models.GetFlowVersionsResponse>
     */
    getFlowVersions(id: string, options?: msRest.RequestOptionsBase): Promise<Models.GetFlowVersionsResponse>;
    /**
     * @param id
     * @param callback The callback
     */
    getFlowVersions(id: string, callback: msRest.ServiceCallback<Models.Flow[]>): void;
    /**
     * @param id
     * @param options The optional parameters
     * @param callback The callback
     */
    getFlowVersions(id: string, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<Models.Flow[]>): void;
    /**
     * @summary Get job mapping.
     * @param id
     * @param [options] The optional parameters
     * @returns Promise<Models.GetJobMappingResponse>
     */
    getJobMapping(id: string, options?: Models.MetabaseApiGetJobMappingOptionalParams): Promise<Models.GetJobMappingResponse>;
    /**
     * @param id
     * @param callback The callback
     */
    getJobMapping(id: string, callback: msRest.ServiceCallback<Models.Mapping>): void;
    /**
     * @param id
     * @param options The optional parameters
     * @param callback The callback
     */
    getJobMapping(id: string, options: Models.MetabaseApiGetJobMappingOptionalParams, callback: msRest.ServiceCallback<Models.Mapping>): void;
    /**
     * @summary Set job status for go between.
     * @param id
     * @param status
     * @param [options] The optional parameters
     * @returns Promise<Models.SetJobStatusForGoBetweenResponse>
     */
    setJobStatusForGoBetween(id: string, status: Models.JobStatusGoBetweenScope, options?: msRest.RequestOptionsBase): Promise<Models.SetJobStatusForGoBetweenResponse>;
    /**
     * @param id
     * @param status
     * @param callback The callback
     */
    setJobStatusForGoBetween(id: string, status: Models.JobStatusGoBetweenScope, callback: msRest.ServiceCallback<{
        [propertyName: string]: string[];
    }>): void;
    /**
     * @param id
     * @param status
     * @param options The optional parameters
     * @param callback The callback
     */
    setJobStatusForGoBetween(id: string, status: Models.JobStatusGoBetweenScope, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<{
        [propertyName: string]: string[];
    }>): void;
    /**
     * @summary Set real time state.
     * @param id
     * @param state
     * @param [options] The optional parameters
     * @returns Promise<Models.SetRealTimeStateResponse>
     */
    setRealTimeState(id: string, state: Models.RealTimeStateScope, options?: msRest.RequestOptionsBase): Promise<Models.SetRealTimeStateResponse>;
    /**
     * @param id
     * @param state
     * @param callback The callback
     */
    setRealTimeState(id: string, state: Models.RealTimeStateScope, callback: msRest.ServiceCallback<{
        [propertyName: string]: string[];
    }>): void;
    /**
     * @param id
     * @param state
     * @param options The optional parameters
     * @param callback The callback
     */
    setRealTimeState(id: string, state: Models.RealTimeStateScope, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<{
        [propertyName: string]: string[];
    }>): void;
    /**
     * @summary Get all jobs.
     * @param [options] The optional parameters
     * @returns Promise<Models.GetAllJobsResponse>
     */
    getAllJobs(options?: Models.MetabaseApiGetAllJobsOptionalParams): Promise<Models.GetAllJobsResponse>;
    /**
     * @param callback The callback
     */
    getAllJobs(callback: msRest.ServiceCallback<Models.Job[]>): void;
    /**
     * @param options The optional parameters
     * @param callback The callback
     */
    getAllJobs(options: Models.MetabaseApiGetAllJobsOptionalParams, callback: msRest.ServiceCallback<Models.Job[]>): void;
    /**
     * @summary Create job.
     * @param input
     * @param [options] The optional parameters
     * @returns Promise<Models.CreateJobResponse>
     */
    createJob(input: Models.Job, options?: msRest.RequestOptionsBase): Promise<Models.CreateJobResponse>;
    /**
     * @param input
     * @param callback The callback
     */
    createJob(input: Models.Job, callback: msRest.ServiceCallback<any>): void;
    /**
     * @param input
     * @param options The optional parameters
     * @param callback The callback
     */
    createJob(input: Models.Job, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<any>): void;
    /**
     * @summary Get paged statuses for job.
     * @param id
     * @param [options] The optional parameters
     * @returns Promise<Models.GetPagedStatusesForJobResponse>
     */
    getPagedStatusesForJob(id: string, options?: Models.MetabaseApiGetPagedStatusesForJobOptionalParams): Promise<Models.GetPagedStatusesForJobResponse>;
    /**
     * @param id
     * @param callback The callback
     */
    getPagedStatusesForJob(id: string, callback: msRest.ServiceCallback<Models.PagedResultOfJobStatus>): void;
    /**
     * @param id
     * @param options The optional parameters
     * @param callback The callback
     */
    getPagedStatusesForJob(id: string, options: Models.MetabaseApiGetPagedStatusesForJobOptionalParams, callback: msRest.ServiceCallback<Models.PagedResultOfJobStatus>): void;
    /**
     * @summary Events placeholder for job.
     * @param [options] The optional parameters
     * @returns Promise<Models.EventsPlaceholderForJobResponse>
     */
    eventsPlaceholderForJob(options?: msRest.RequestOptionsBase): Promise<Models.EventsPlaceholderForJobResponse>;
    /**
     * @param callback The callback
     */
    eventsPlaceholderForJob(callback: msRest.ServiceCallback<Models.DataflowEvent>): void;
    /**
     * @param options The optional parameters
     * @param callback The callback
     */
    eventsPlaceholderForJob(options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<Models.DataflowEvent>): void;
    /**
     * @summary Get one job.
     * @param id
     * @param [options] The optional parameters
     * @returns Promise<Models.GetOneJobResponse>
     */
    getOneJob(id: string, options?: Models.MetabaseApiGetOneJobOptionalParams): Promise<Models.GetOneJobResponse>;
    /**
     * @param id
     * @param callback The callback
     */
    getOneJob(id: string, callback: msRest.ServiceCallback<Models.Job>): void;
    /**
     * @param id
     * @param options The optional parameters
     * @param callback The callback
     */
    getOneJob(id: string, options: Models.MetabaseApiGetOneJobOptionalParams, callback: msRest.ServiceCallback<Models.Job>): void;
    /**
     * @summary Update job.
     * @param id
     * @param model
     * @param [options] The optional parameters
     * @returns Promise<Models.UpdateJobResponse>
     */
    updateJob(id: string, model: Models.Job, options?: msRest.RequestOptionsBase): Promise<Models.UpdateJobResponse>;
    /**
     * @param id
     * @param model
     * @param callback The callback
     */
    updateJob(id: string, model: Models.Job, callback: msRest.ServiceCallback<any>): void;
    /**
     * @param id
     * @param model
     * @param options The optional parameters
     * @param callback The callback
     */
    updateJob(id: string, model: Models.Job, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<any>): void;
    /**
     * @summary Delete job.
     * @param id
     * @param [options] The optional parameters
     * @returns Promise<msRest.RestResponse>
     */
    deleteJob(id: string, options?: msRest.RequestOptionsBase): Promise<msRest.RestResponse>;
    /**
     * @param id
     * @param callback The callback
     */
    deleteJob(id: string, callback: msRest.ServiceCallback<void>): void;
    /**
     * @param id
     * @param options The optional parameters
     * @param callback The callback
     */
    deleteJob(id: string, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<void>): void;
    /**
     * @summary Get job versions.
     * @param id
     * @param [options] The optional parameters
     * @returns Promise<Models.GetJobVersionsResponse>
     */
    getJobVersions(id: string, options?: msRest.RequestOptionsBase): Promise<Models.GetJobVersionsResponse>;
    /**
     * @param id
     * @param callback The callback
     */
    getJobVersions(id: string, callback: msRest.ServiceCallback<Models.Job[]>): void;
    /**
     * @param id
     * @param options The optional parameters
     * @param callback The callback
     */
    getJobVersions(id: string, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<Models.Job[]>): void;
    /**
     * @summary Get all schema profiles.
     * @param [options] The optional parameters
     * @returns Promise<Models.GetAllSchemaProfilesResponse>
     */
    getAllSchemaProfiles(options?: Models.MetabaseApiGetAllSchemaProfilesOptionalParams): Promise<Models.GetAllSchemaProfilesResponse>;
    /**
     * @param callback The callback
     */
    getAllSchemaProfiles(callback: msRest.ServiceCallback<Models.SchemaProfile[]>): void;
    /**
     * @param options The optional parameters
     * @param callback The callback
     */
    getAllSchemaProfiles(options: Models.MetabaseApiGetAllSchemaProfilesOptionalParams, callback: msRest.ServiceCallback<Models.SchemaProfile[]>): void;
    /**
     * @summary Create schema profile.
     * @param input
     * @param [options] The optional parameters
     * @returns Promise<Models.CreateSchemaProfileResponse>
     */
    createSchemaProfile(input: Models.SchemaProfile, options?: msRest.RequestOptionsBase): Promise<Models.CreateSchemaProfileResponse>;
    /**
     * @param input
     * @param callback The callback
     */
    createSchemaProfile(input: Models.SchemaProfile, callback: msRest.ServiceCallback<any>): void;
    /**
     * @param input
     * @param options The optional parameters
     * @param callback The callback
     */
    createSchemaProfile(input: Models.SchemaProfile, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<any>): void;
    /**
     * @summary Get one schema profile.
     * @param id
     * @param [options] The optional parameters
     * @returns Promise<Models.GetOneSchemaProfileResponse>
     */
    getOneSchemaProfile(id: string, options?: Models.MetabaseApiGetOneSchemaProfileOptionalParams): Promise<Models.GetOneSchemaProfileResponse>;
    /**
     * @param id
     * @param callback The callback
     */
    getOneSchemaProfile(id: string, callback: msRest.ServiceCallback<Models.SchemaProfile>): void;
    /**
     * @param id
     * @param options The optional parameters
     * @param callback The callback
     */
    getOneSchemaProfile(id: string, options: Models.MetabaseApiGetOneSchemaProfileOptionalParams, callback: msRest.ServiceCallback<Models.SchemaProfile>): void;
    /**
     * @summary Update schema profile.
     * @param id
     * @param model
     * @param [options] The optional parameters
     * @returns Promise<Models.UpdateSchemaProfileResponse>
     */
    updateSchemaProfile(id: string, model: Models.SchemaProfile, options?: msRest.RequestOptionsBase): Promise<Models.UpdateSchemaProfileResponse>;
    /**
     * @param id
     * @param model
     * @param callback The callback
     */
    updateSchemaProfile(id: string, model: Models.SchemaProfile, callback: msRest.ServiceCallback<any>): void;
    /**
     * @param id
     * @param model
     * @param options The optional parameters
     * @param callback The callback
     */
    updateSchemaProfile(id: string, model: Models.SchemaProfile, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<any>): void;
    /**
     * @summary Delete schema profile.
     * @param id
     * @param [options] The optional parameters
     * @returns Promise<msRest.RestResponse>
     */
    deleteSchemaProfile(id: string, options?: msRest.RequestOptionsBase): Promise<msRest.RestResponse>;
    /**
     * @param id
     * @param callback The callback
     */
    deleteSchemaProfile(id: string, callback: msRest.ServiceCallback<void>): void;
    /**
     * @param id
     * @param options The optional parameters
     * @param callback The callback
     */
    deleteSchemaProfile(id: string, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<void>): void;
    /**
     * @summary Get schema profile versions.
     * @param id
     * @param [options] The optional parameters
     * @returns Promise<Models.GetSchemaProfileVersionsResponse>
     */
    getSchemaProfileVersions(id: string, options?: msRest.RequestOptionsBase): Promise<Models.GetSchemaProfileVersionsResponse>;
    /**
     * @param id
     * @param callback The callback
     */
    getSchemaProfileVersions(id: string, callback: msRest.ServiceCallback<Models.SchemaProfile[]>): void;
    /**
     * @param id
     * @param options The optional parameters
     * @param callback The callback
     */
    getSchemaProfileVersions(id: string, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<Models.SchemaProfile[]>): void;
    /**
     * @summary Get all schemas.
     * @param [options] The optional parameters
     * @returns Promise<Models.GetAllSchemasResponse>
     */
    getAllSchemas(options?: Models.MetabaseApiGetAllSchemasOptionalParams): Promise<Models.GetAllSchemasResponse>;
    /**
     * @param callback The callback
     */
    getAllSchemas(callback: msRest.ServiceCallback<Models.Schema[]>): void;
    /**
     * @param options The optional parameters
     * @param callback The callback
     */
    getAllSchemas(options: Models.MetabaseApiGetAllSchemasOptionalParams, callback: msRest.ServiceCallback<Models.Schema[]>): void;
    /**
     * @summary Create schema.
     * @param input
     * @param [options] The optional parameters
     * @returns Promise<Models.CreateSchemaResponse>
     */
    createSchema(input: Models.Schema, options?: msRest.RequestOptionsBase): Promise<Models.CreateSchemaResponse>;
    /**
     * @param input
     * @param callback The callback
     */
    createSchema(input: Models.Schema, callback: msRest.ServiceCallback<any>): void;
    /**
     * @param input
     * @param options The optional parameters
     * @param callback The callback
     */
    createSchema(input: Models.Schema, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<any>): void;
    /**
     * @summary Get one schema.
     * @param id
     * @param [options] The optional parameters
     * @returns Promise<Models.GetOneSchemaResponse>
     */
    getOneSchema(id: string, options?: Models.MetabaseApiGetOneSchemaOptionalParams): Promise<Models.GetOneSchemaResponse>;
    /**
     * @param id
     * @param callback The callback
     */
    getOneSchema(id: string, callback: msRest.ServiceCallback<Models.Schema>): void;
    /**
     * @param id
     * @param options The optional parameters
     * @param callback The callback
     */
    getOneSchema(id: string, options: Models.MetabaseApiGetOneSchemaOptionalParams, callback: msRest.ServiceCallback<Models.Schema>): void;
    /**
     * @summary Update schema.
     * @param id
     * @param model
     * @param [options] The optional parameters
     * @returns Promise<Models.UpdateSchemaResponse>
     */
    updateSchema(id: string, model: Models.Schema, options?: msRest.RequestOptionsBase): Promise<Models.UpdateSchemaResponse>;
    /**
     * @param id
     * @param model
     * @param callback The callback
     */
    updateSchema(id: string, model: Models.Schema, callback: msRest.ServiceCallback<any>): void;
    /**
     * @param id
     * @param model
     * @param options The optional parameters
     * @param callback The callback
     */
    updateSchema(id: string, model: Models.Schema, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<any>): void;
    /**
     * @summary Delete schema.
     * @param id
     * @param [options] The optional parameters
     * @returns Promise<msRest.RestResponse>
     */
    deleteSchema(id: string, options?: msRest.RequestOptionsBase): Promise<msRest.RestResponse>;
    /**
     * @param id
     * @param callback The callback
     */
    deleteSchema(id: string, callback: msRest.ServiceCallback<void>): void;
    /**
     * @param id
     * @param options The optional parameters
     * @param callback The callback
     */
    deleteSchema(id: string, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<void>): void;
    /**
     * @summary Get schema versions.
     * @param id
     * @param [options] The optional parameters
     * @returns Promise<Models.GetSchemaVersionsResponse>
     */
    getSchemaVersions(id: string, options?: msRest.RequestOptionsBase): Promise<Models.GetSchemaVersionsResponse>;
    /**
     * @param id
     * @param callback The callback
     */
    getSchemaVersions(id: string, callback: msRest.ServiceCallback<Models.Schema[]>): void;
    /**
     * @param id
     * @param options The optional parameters
     * @param callback The callback
     */
    getSchemaVersions(id: string, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<Models.Schema[]>): void;
    /**
     * @summary Get all shapes.
     * @param [options] The optional parameters
     * @returns Promise<Models.GetAllShapesResponse>
     */
    getAllShapes(options?: Models.MetabaseApiGetAllShapesOptionalParams): Promise<Models.GetAllShapesResponse>;
    /**
     * @param callback The callback
     */
    getAllShapes(callback: msRest.ServiceCallback<Models.Shape[]>): void;
    /**
     * @param options The optional parameters
     * @param callback The callback
     */
    getAllShapes(options: Models.MetabaseApiGetAllShapesOptionalParams, callback: msRest.ServiceCallback<Models.Shape[]>): void;
    /**
     * @summary Create shape.
     * @param input
     * @param [options] The optional parameters
     * @returns Promise<Models.CreateShapeResponse>
     */
    createShape(input: Models.Shape, options?: msRest.RequestOptionsBase): Promise<Models.CreateShapeResponse>;
    /**
     * @param input
     * @param callback The callback
     */
    createShape(input: Models.Shape, callback: msRest.ServiceCallback<any>): void;
    /**
     * @param input
     * @param options The optional parameters
     * @param callback The callback
     */
    createShape(input: Models.Shape, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<any>): void;
    /**
     * @summary Get one shape.
     * @param id
     * @param [options] The optional parameters
     * @returns Promise<Models.GetOneShapeResponse>
     */
    getOneShape(id: string, options?: Models.MetabaseApiGetOneShapeOptionalParams): Promise<Models.GetOneShapeResponse>;
    /**
     * @param id
     * @param callback The callback
     */
    getOneShape(id: string, callback: msRest.ServiceCallback<Models.Shape>): void;
    /**
     * @param id
     * @param options The optional parameters
     * @param callback The callback
     */
    getOneShape(id: string, options: Models.MetabaseApiGetOneShapeOptionalParams, callback: msRest.ServiceCallback<Models.Shape>): void;
    /**
     * @summary Update shape.
     * @param id
     * @param model
     * @param [options] The optional parameters
     * @returns Promise<Models.UpdateShapeResponse>
     */
    updateShape(id: string, model: Models.Shape, options?: msRest.RequestOptionsBase): Promise<Models.UpdateShapeResponse>;
    /**
     * @param id
     * @param model
     * @param callback The callback
     */
    updateShape(id: string, model: Models.Shape, callback: msRest.ServiceCallback<any>): void;
    /**
     * @param id
     * @param model
     * @param options The optional parameters
     * @param callback The callback
     */
    updateShape(id: string, model: Models.Shape, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<any>): void;
    /**
     * @summary Delete shape.
     * @param id
     * @param [options] The optional parameters
     * @returns Promise<msRest.RestResponse>
     */
    deleteShape(id: string, options?: msRest.RequestOptionsBase): Promise<msRest.RestResponse>;
    /**
     * @param id
     * @param callback The callback
     */
    deleteShape(id: string, callback: msRest.ServiceCallback<void>): void;
    /**
     * @param id
     * @param options The optional parameters
     * @param callback The callback
     */
    deleteShape(id: string, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<void>): void;
    /**
     * @summary Get shape versions.
     * @param id
     * @param [options] The optional parameters
     * @returns Promise<Models.GetShapeVersionsResponse>
     */
    getShapeVersions(id: string, options?: msRest.RequestOptionsBase): Promise<Models.GetShapeVersionsResponse>;
    /**
     * @param id
     * @param callback The callback
     */
    getShapeVersions(id: string, callback: msRest.ServiceCallback<Models.Shape[]>): void;
    /**
     * @param id
     * @param options The optional parameters
     * @param callback The callback
     */
    getShapeVersions(id: string, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<Models.Shape[]>): void;
}
export { MetabaseApi, MetabaseApiContext, Models as MetabaseApiModels, Mappers as MetabaseApiMappers };
//# sourceMappingURL=metabaseApi.d.ts.map