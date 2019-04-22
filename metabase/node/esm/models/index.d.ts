import { ServiceClientOptions } from "@azure/ms-rest-js";
import * as msRest from "@azure/ms-rest-js";
/**
 * An interface representing BatchStatusGoBetweenScope.
 */
export interface BatchStatusGoBetweenScope {
    resourceId?: string;
    updatedAt?: Date;
    updatedBy?: string;
    startedOnAgent?: string;
    startedAt?: Date;
    expectedToEndBefore?: Date;
    endedAt?: Date;
    expectedCount?: number;
    dataPointsPerMinute?: number;
    count?: number;
    filteredCount?: number;
    deflectedCount?: number;
    badRecordCount?: number;
    endedReason?: string;
    endedMessage?: string;
    badRecordSample?: {
        [propertyName: string]: any;
    }[];
}
/**
 * An interface representing BatchStatus.
 */
export interface BatchStatus {
    resourceId?: string;
    updatedAt?: Date;
    updatedBy?: string;
    goBetweenAgent?: BatchStatusGoBetweenScope;
}
/**
 * An interface representing PagedResultOfBatchStatus.
 */
export interface PagedResultOfBatchStatus {
    pageSize?: number;
    currentPage?: number;
    totalItems?: number;
    items?: BatchStatus[];
}
/**
 * An interface representing Payload.
 */
export interface Payload {
    m?: any;
}
/**
 * An interface representing Trace.
 */
export interface Trace {
    n?: string;
    ts?: Date;
    d?: number;
}
/**
 * An interface representing DataflowEvent.
 */
export interface DataflowEvent {
    d?: Payload;
    id: string;
    tid: string;
    sid?: string;
    jid?: string;
    bid?: string;
    rid: string;
    rids?: string[];
    cid: string;
    m?: {
        [propertyName: string]: any;
    };
    trc?: Trace[];
}
/**
 * An interface representing Batch.
 */
export interface Batch {
    id?: string;
    version?: number;
    name: string;
    description?: string;
    jobId: string;
    status?: BatchStatus;
    createdAt?: Date;
    createdBy?: string;
    updatedAt?: Date;
    updatedBy?: string;
    deletedAt?: Date;
    deletedBy?: string;
}
/**
 * An interface representing PluginCapabilities.
 */
export interface PluginCapabilities {
    canAcceptQueryBasedSchemas?: boolean;
    canConfigure?: boolean;
    canConfigureConnection?: boolean;
    canConfigureQualityCheck?: boolean;
    canConfigureQuery?: boolean;
    canConfigureRealTime?: boolean;
    canConfigureWrite?: boolean;
    canDiscoverShapes?: boolean;
    canProduceMultipleSchemas?: boolean;
    canPublish?: boolean;
    canUseOAuth?: boolean;
    canWrite?: boolean;
}
/**
 * An interface representing ConnectionDiscoveredSchema.
 */
export interface ConnectionDiscoveredSchema {
    discoveredSchemaId?: string;
    isAdvertised?: boolean;
    advertisedSchemaId?: string;
}
/**
 * An interface representing Connection.
 */
export interface Connection {
    id?: string;
    version?: number;
    name: string;
    description?: string;
    roles?: ConnectionRole[];
    labels?: {
        [propertyName: string]: string;
    };
    plugin: string;
    settings?: {
        [propertyName: string]: any;
    };
    preferredAgent?: string;
    canRunInCloud?: boolean;
    pluginCapabilities?: PluginCapabilities;
    discoveredSchemas?: ConnectionDiscoveredSchema[];
    createdAt?: Date;
    createdBy?: string;
    updatedAt?: Date;
    updatedBy?: string;
    deletedAt?: Date;
    deletedBy?: string;
}
/**
 * An interface representing PublishNode.
 */
export interface PublishNode {
    shapeId?: string;
    connectionId?: string;
}
/**
 * An interface representing MapNode.
 */
export interface MapNode {
    mappingId?: string;
}
/**
 * An interface representing Node.
 */
export interface Node {
    id: string;
    name?: string;
    /**
     * Possible values include: 'unknown', 'publish', 'map', 'injest', 'enrich', 'match', 'merge',
     * 'terminal'
     */
    type?: NodeType;
    publish?: PublishNode;
    map?: MapNode;
    injest?: any;
    match?: any;
    merge?: any;
    terminal?: any;
}
/**
 * An interface representing KafkaEdge.
 */
export interface KafkaEdge {
    topicTemplate?: string;
}
/**
 * An interface representing HttpEdge.
 */
export interface HttpEdge {
    endpoint?: string;
}
/**
 * An interface representing Edge.
 */
export interface Edge {
    id: string;
    fromId: string;
    toId: string;
    /**
     * Possible values include: 'unknown', 'inProcess', 'kafka', 'http'
     */
    type?: EdgeType;
    inProcess?: any;
    kafka?: KafkaEdge;
    http?: HttpEdge;
}
/**
 * An interface representing Flow.
 */
export interface Flow {
    id?: string;
    version?: number;
    name: string;
    description?: string;
    nodes?: {
        [propertyName: string]: Node;
    };
    edges?: {
        [propertyName: string]: Edge;
    };
    createdAt?: Date;
    createdBy?: string;
    updatedAt?: Date;
    updatedBy?: string;
    deletedAt?: Date;
    deletedBy?: string;
}
/**
 * An interface representing Transform.
 */
export interface Transform {
    transformId?: string;
    format?: string;
}
/**
 * An interface representing PropertyMapping.
 */
export interface PropertyMapping {
    fromPropertyId: string;
    toPropertyId: string;
    /**
     * Possible values include: 'primaryDataPropertyId', 'schemaDataPropertyId',
     * 'enrichedDataPropertyId'
     */
    fromPropertyMeaning?: PropertyIdMeaning;
    /**
     * Possible values include: 'primaryDataPropertyId', 'schemaDataPropertyId',
     * 'enrichedDataPropertyId'
     */
    toPropertyMeaning?: PropertyIdMeaning;
    transform?: Transform;
    transforms?: Transform[];
}
/**
 * An interface representing Mapping.
 */
export interface Mapping {
    id?: string;
    version?: number;
    name: string;
    description?: string;
    /**
     * Possible values include: 'schemaToShape', 'shapeToSchema'
     */
    direction?: MappingDirection;
    schemaId: string;
    shapeId: string;
    propertyMappings: PropertyMapping[];
    createdAt?: Date;
    createdBy?: string;
    updatedAt?: Date;
    updatedBy?: string;
    deletedAt?: Date;
    deletedBy?: string;
}
/**
 * An interface representing JobStatusGoBetweenScope.
 */
export interface JobStatusGoBetweenScope {
    resourceId?: string;
    updatedAt?: Date;
    updatedBy?: string;
    error?: string;
    message?: string;
    startCount?: number;
    successCount?: number;
    consecutiveFailureCount?: number;
    state?: string;
    nextRunAt?: Date;
    previousRunAt?: Date;
    scheduledOn?: string;
    scheduledAt?: Date;
}
/**
 * An interface representing RealTimeStateScope.
 */
export interface RealTimeStateScope {
    resourceId?: string;
    updatedAt?: Date;
    updatedBy?: string;
    realTimeState?: string;
}
/**
 * An interface representing RealTimeSettings.
 */
export interface RealTimeSettings {
    stateCheckpointInterval?: string;
    settings?: {
        [propertyName: string]: any;
    };
    schema?: {
        [propertyName: string]: any;
    };
    uiSchema?: {
        [propertyName: string]: any;
    };
}
/**
 * An interface representing Schedule.
 */
export interface Schedule {
    /**
     * Possible values include: 'never', 'immediate', 'onDemand', 'once', 'interval', 'cron',
     * 'realTime', 'always'
     */
    type?: ScheduleType;
    cron?: string;
    pointInTime?: Date;
    description?: string;
    realTimeSettings?: RealTimeSettings;
}
/**
 * An interface representing Writeback.
 */
export interface Writeback {
    writebackId: string;
}
/**
 * An interface representing FilterRule.
 */
export interface FilterRule {
    /**
     * Possible values include: 'include', 'exclude'
     */
    effect?: FilterRuleEffect;
    propertyId?: string;
    operatorId?: string;
    parameter?: any;
}
/**
 * An interface representing Filter.
 */
export interface Filter {
    rules?: FilterRule[];
}
/**
 * An interface representing JobStatus.
 */
export interface JobStatus {
    resourceId?: string;
    updatedAt?: Date;
    updatedBy?: string;
    goBetween?: JobStatusGoBetweenScope;
    realTime?: RealTimeStateScope;
}
/**
 * An interface representing Job.
 */
export interface Job {
    id?: string;
    version?: number;
    name: string;
    description?: string;
    schedule?: Schedule;
    connectionId?: string;
    schemaId?: string;
    shapeId?: string;
    agentId?: string;
    canRunInCloud?: boolean;
    dataVersion?: number;
    propertyMappings?: PropertyMapping[];
    /**
     * Possible values include: 'read', 'write', 'profiling', 'qualityCheck'
     */
    type?: JobType;
    isPaused?: boolean;
    writeback?: Writeback;
    filter?: Filter;
    status?: JobStatus;
    latestBatch?: Batch;
    createdAt?: Date;
    createdBy?: string;
    updatedAt?: Date;
    updatedBy?: string;
    deletedAt?: Date;
    deletedBy?: string;
}
/**
 * An interface representing PagedResultOfJobStatus.
 */
export interface PagedResultOfJobStatus {
    pageSize?: number;
    currentPage?: number;
    totalItems?: number;
    items?: JobStatus[];
}
/**
 * An interface representing TraitAttributeDefinition.
 */
export interface TraitAttributeDefinition {
    id?: string;
    name?: string;
    /**
     * Possible values include: 'string', 'count', 'percent', 'statistic', 'details', 'histogram',
     * 'boxplot'
     */
    type?: TraitAttributeType;
}
/**
 * An interface representing TraitDefinition.
 */
export interface TraitDefinition {
    id?: string;
    name?: string;
    family?: string;
    order?: number;
    description?: string;
    help?: string;
    attributes?: TraitAttributeDefinition[];
}
/**
 * An interface representing SchemaTrait.
 */
export interface SchemaTrait {
    id?: string;
    error?: string;
    attributeValues?: {
        [propertyName: string]: any;
    };
}
/**
 * An interface representing PropertyTrait.
 */
export interface PropertyTrait {
    propertyId?: string;
    id?: string;
    error?: string;
    attributeValues?: {
        [propertyName: string]: any;
    };
}
/**
 * An interface representing SchemaProfile.
 */
export interface SchemaProfile {
    id?: string;
    version?: number;
    name: string;
    description?: string;
    schemaVersion?: number;
    connectionId?: string;
    count?: number;
    startedOn?: Date;
    completedOn?: Date;
    traitDefinitions?: TraitDefinition[];
    schemaTraits?: SchemaTrait[];
    propertyTraits?: PropertyTrait[];
    createdAt?: Date;
    createdBy?: string;
    updatedAt?: Date;
    updatedBy?: string;
    deletedAt?: Date;
    deletedBy?: string;
}
/**
 * An interface representing Boxplot.
 */
export interface Boxplot {
    min?: number;
    q1?: number;
    median?: number;
    q3?: number;
    max?: number;
}
/**
 * An interface representing Histogram.
 */
export interface Histogram {
    min?: number;
    max?: number;
    count?: number;
    frequencies?: number[];
}
/**
 * An interface representing SchemaProperty.
 */
export interface SchemaProperty {
    id?: string;
    name?: string;
    discoveredName?: string;
    discoveredDescription?: string;
    description?: string;
    /**
     * Possible values include: 'string', 'bool', 'integer', 'float', 'decimal', 'date', 'time',
     * 'datetime', 'text', 'blob', 'json'
     */
    type?: PropertyType;
    discoveredType?: string;
    isKey?: boolean;
    isNullable?: boolean;
    isCreateCounter?: boolean;
    isUpdateCounter?: boolean;
    publisherMetaJson?: string;
}
/**
 * An interface representing SchemaForm.
 */
export interface SchemaForm {
    settings?: {
        [propertyName: string]: any;
    };
    jsonSchema?: {
        [propertyName: string]: any;
    };
    uiSchema?: {
        [propertyName: string]: any;
    };
}
/**
 * An interface representing Schema.
 */
export interface Schema {
    id?: string;
    version?: number;
    name: string;
    description?: string;
    discoveredId?: string;
    discoveredName?: string;
    discoveredDescription?: string;
    isUserDefined?: boolean;
    properties?: SchemaProperty[];
    labels?: {
        [propertyName: string]: string;
    };
    query?: string;
    connectionId?: string;
    profilingJobId?: string;
    hasProfile?: boolean;
    publisherMetaJson?: string;
    /**
     * Possible values include: 'read', 'write', 'readWrite', 'qualityCheck'
     */
    capability?: SchemaCapability;
    form?: SchemaForm;
    templateDimensions?: {
        [propertyName: string]: string;
    };
    createdAt?: Date;
    createdBy?: string;
    updatedAt?: Date;
    updatedBy?: string;
    deletedAt?: Date;
    deletedBy?: string;
}
/**
 * An interface representing ShapePropertySecurity.
 */
export interface ShapePropertySecurity {
    /**
     * Possible values include: 'none', 'aesgcm', 'sha256Hmac'
     */
    algorithm?: SecurityAlgorithm;
    /**
     * Possible values include: 'vault', 'file'
     */
    keyStorage?: SecurityKeyStorage;
    key?: string;
}
/**
 * An interface representing ShapeProperty.
 */
export interface ShapeProperty {
    id?: string;
    name?: string;
    description?: string;
    /**
     * Possible values include: 'string', 'bool', 'integer', 'float', 'decimal', 'date', 'time',
     * 'datetime', 'text', 'blob', 'json'
     */
    type?: PropertyType;
    isUnique?: boolean;
    security?: ShapePropertySecurity;
    isNullable?: boolean;
    isHidden?: boolean;
}
/**
 * An interface representing MatchRule.
 */
export interface MatchRule {
    shapeId: string;
    version?: number;
    mcl?: number;
    type: string;
    settings?: {
        [propertyName: string]: any;
    };
}
/**
 * An interface representing PropertyMergeRule.
 */
export interface PropertyMergeRule {
    propertyId?: string;
    connections?: string[];
}
/**
 * An interface representing MergeRule.
 */
export interface MergeRule {
    version?: number;
    properties?: {
        [propertyName: string]: PropertyMergeRule;
    };
}
/**
 * An interface representing Shape.
 */
export interface Shape {
    id?: string;
    version?: number;
    name: string;
    description?: string;
    properties?: ShapeProperty[];
    labels?: {
        [propertyName: string]: string;
    };
    isMdmShape?: boolean;
    matchRule?: MatchRule;
    mergeRule?: MergeRule;
    copiedFromSchemaId?: string;
    createdAt?: Date;
    createdBy?: string;
    updatedAt?: Date;
    updatedBy?: string;
    deletedAt?: Date;
    deletedBy?: string;
}
/**
 * An interface representing MetabaseApiOptions.
 */
export interface MetabaseApiOptions extends ServiceClientOptions {
    baseUri?: string;
}
/**
 * Optional Parameters.
 */
export interface MetabaseApiGetPagedStatusesForBatchOptionalParams extends msRest.RequestOptionsBase {
    page?: number;
    pageSize?: number;
}
/**
 * Optional Parameters.
 */
export interface MetabaseApiGetAllBatchesOptionalParams extends msRest.RequestOptionsBase {
    id?: string;
    name?: string;
    description?: string;
    jobId?: string;
    createdBy?: string;
    updatedBy?: string;
    deletedBy?: string;
}
/**
 * Optional Parameters.
 */
export interface MetabaseApiGetOneBatchOptionalParams extends msRest.RequestOptionsBase {
    version?: number;
}
/**
 * Optional Parameters.
 */
export interface MetabaseApiGetAllConnectionsOptionalParams extends msRest.RequestOptionsBase {
    id?: string;
    name?: string;
    description?: string;
    plugin?: string;
    preferredAgent?: string;
    createdBy?: string;
    updatedBy?: string;
    deletedBy?: string;
}
/**
 * Optional Parameters.
 */
export interface MetabaseApiGetOneConnectionOptionalParams extends msRest.RequestOptionsBase {
    version?: number;
}
/**
 * Optional Parameters.
 */
export interface MetabaseApiGetAllFlowsOptionalParams extends msRest.RequestOptionsBase {
    id?: string;
    name?: string;
    description?: string;
    createdBy?: string;
    updatedBy?: string;
    deletedBy?: string;
}
/**
 * Optional Parameters.
 */
export interface MetabaseApiGetOneFlowOptionalParams extends msRest.RequestOptionsBase {
    version?: number;
}
/**
 * Optional Parameters.
 */
export interface MetabaseApiGetJobMappingOptionalParams extends msRest.RequestOptionsBase {
    version?: number;
}
/**
 * Optional Parameters.
 */
export interface MetabaseApiGetAllJobsOptionalParams extends msRest.RequestOptionsBase {
    id?: string;
    name?: string;
    description?: string;
    connectionId?: string;
    schemaId?: string;
    shapeId?: string;
    agentId?: string;
    type?: string;
    createdBy?: string;
    updatedBy?: string;
    deletedBy?: string;
}
/**
 * Optional Parameters.
 */
export interface MetabaseApiGetPagedStatusesForJobOptionalParams extends msRest.RequestOptionsBase {
    page?: number;
    pageSize?: number;
}
/**
 * Optional Parameters.
 */
export interface MetabaseApiGetOneJobOptionalParams extends msRest.RequestOptionsBase {
    version?: number;
}
/**
 * Optional Parameters.
 */
export interface MetabaseApiGetAllSchemaProfilesOptionalParams extends msRest.RequestOptionsBase {
    id?: string;
    name?: string;
    description?: string;
    connectionId?: string;
    createdBy?: string;
    updatedBy?: string;
    deletedBy?: string;
}
/**
 * Optional Parameters.
 */
export interface MetabaseApiGetOneSchemaProfileOptionalParams extends msRest.RequestOptionsBase {
    version?: number;
}
/**
 * Optional Parameters.
 */
export interface MetabaseApiGetAllSchemasOptionalParams extends msRest.RequestOptionsBase {
    id?: string;
    name?: string;
    description?: string;
    discoveredId?: string;
    discoveredName?: string;
    discoveredDescription?: string;
    query?: string;
    connectionId?: string;
    profilingJobId?: string;
    publisherMetaJson?: string;
    capability?: string;
    createdBy?: string;
    updatedBy?: string;
    deletedBy?: string;
}
/**
 * Optional Parameters.
 */
export interface MetabaseApiGetOneSchemaOptionalParams extends msRest.RequestOptionsBase {
    version?: number;
}
/**
 * Optional Parameters.
 */
export interface MetabaseApiGetAllShapesOptionalParams extends msRest.RequestOptionsBase {
    id?: string;
    name?: string;
    description?: string;
    copiedFromSchemaId?: string;
    createdBy?: string;
    updatedBy?: string;
    deletedBy?: string;
}
/**
 * Optional Parameters.
 */
export interface MetabaseApiGetOneShapeOptionalParams extends msRest.RequestOptionsBase {
    version?: number;
}
/**
 * Defines values for ConnectionRole.
 * Possible values include: 'publisher', 'subscriber'
 * @readonly
 * @enum {string}
 */
export declare type ConnectionRole = 'publisher' | 'subscriber';
/**
 * Defines values for NodeType.
 * Possible values include: 'unknown', 'publish', 'map', 'injest', 'enrich', 'match', 'merge',
 * 'terminal'
 * @readonly
 * @enum {string}
 */
export declare type NodeType = 'unknown' | 'publish' | 'map' | 'injest' | 'enrich' | 'match' | 'merge' | 'terminal';
/**
 * Defines values for EdgeType.
 * Possible values include: 'unknown', 'inProcess', 'kafka', 'http'
 * @readonly
 * @enum {string}
 */
export declare type EdgeType = 'unknown' | 'inProcess' | 'kafka' | 'http';
/**
 * Defines values for MappingDirection.
 * Possible values include: 'schemaToShape', 'shapeToSchema'
 * @readonly
 * @enum {string}
 */
export declare type MappingDirection = 'schemaToShape' | 'shapeToSchema';
/**
 * Defines values for PropertyIdMeaning.
 * Possible values include: 'primaryDataPropertyId', 'schemaDataPropertyId',
 * 'enrichedDataPropertyId'
 * @readonly
 * @enum {string}
 */
export declare type PropertyIdMeaning = 'primaryDataPropertyId' | 'schemaDataPropertyId' | 'enrichedDataPropertyId';
/**
 * Defines values for ScheduleType.
 * Possible values include: 'never', 'immediate', 'onDemand', 'once', 'interval', 'cron',
 * 'realTime', 'always'
 * @readonly
 * @enum {string}
 */
export declare type ScheduleType = 'never' | 'immediate' | 'onDemand' | 'once' | 'interval' | 'cron' | 'realTime' | 'always';
/**
 * Defines values for JobType.
 * Possible values include: 'read', 'write', 'profiling', 'qualityCheck'
 * @readonly
 * @enum {string}
 */
export declare type JobType = 'read' | 'write' | 'profiling' | 'qualityCheck';
/**
 * Defines values for FilterRuleEffect.
 * Possible values include: 'include', 'exclude'
 * @readonly
 * @enum {string}
 */
export declare type FilterRuleEffect = 'include' | 'exclude';
/**
 * Defines values for TraitAttributeType.
 * Possible values include: 'string', 'count', 'percent', 'statistic', 'details', 'histogram',
 * 'boxplot'
 * @readonly
 * @enum {string}
 */
export declare type TraitAttributeType = 'string' | 'count' | 'percent' | 'statistic' | 'details' | 'histogram' | 'boxplot';
/**
 * Defines values for PropertyType.
 * Possible values include: 'string', 'bool', 'integer', 'float', 'decimal', 'date', 'time',
 * 'datetime', 'text', 'blob', 'json'
 * @readonly
 * @enum {string}
 */
export declare type PropertyType = 'string' | 'bool' | 'integer' | 'float' | 'decimal' | 'date' | 'time' | 'datetime' | 'text' | 'blob' | 'json';
/**
 * Defines values for SchemaCapability.
 * Possible values include: 'read', 'write', 'readWrite', 'qualityCheck'
 * @readonly
 * @enum {string}
 */
export declare type SchemaCapability = 'read' | 'write' | 'readWrite' | 'qualityCheck';
/**
 * Defines values for SecurityAlgorithm.
 * Possible values include: 'none', 'aesgcm', 'sha256Hmac'
 * @readonly
 * @enum {string}
 */
export declare type SecurityAlgorithm = 'none' | 'aesgcm' | 'sha256Hmac';
/**
 * Defines values for SecurityKeyStorage.
 * Possible values include: 'vault', 'file'
 * @readonly
 * @enum {string}
 */
export declare type SecurityKeyStorage = 'vault' | 'file';
/**
 * Contains response data for the setBatchStatusForGoBetweenBatch operation.
 */
export declare type SetBatchStatusForGoBetweenBatchResponse = {
    /**
     * The response body properties.
     */
    [propertyName: string]: string[];
} & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: {
            [propertyName: string]: string[];
        };
    };
};
/**
 * Contains response data for the getPagedStatusesForBatch operation.
 */
export declare type GetPagedStatusesForBatchResponse = PagedResultOfBatchStatus & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: PagedResultOfBatchStatus;
    };
};
/**
 * Contains response data for the eventsPlaceholderForBatch operation.
 */
export declare type EventsPlaceholderForBatchResponse = DataflowEvent & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: DataflowEvent;
    };
};
/**
 * Contains response data for the getAllBatches operation.
 */
export declare type GetAllBatchesResponse = Array<Batch> & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: Batch[];
    };
};
/**
 * Contains response data for the createBatch operation.
 */
export declare type CreateBatchResponse = {
    /**
     * The parsed response body.
     */
    body: any;
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: any;
    };
};
/**
 * Contains response data for the getOneBatch operation.
 */
export declare type GetOneBatchResponse = Batch & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: Batch;
    };
};
/**
 * Contains response data for the updateBatch operation.
 */
export declare type UpdateBatchResponse = {
    /**
     * The parsed response body.
     */
    body: any;
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: any;
    };
};
/**
 * Contains response data for the getBatchVersions operation.
 */
export declare type GetBatchVersionsResponse = Array<Batch> & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: Batch[];
    };
};
/**
 * Contains response data for the getAllConnections operation.
 */
export declare type GetAllConnectionsResponse = Array<Connection> & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: Connection[];
    };
};
/**
 * Contains response data for the createConnection operation.
 */
export declare type CreateConnectionResponse = {
    /**
     * The parsed response body.
     */
    body: any;
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: any;
    };
};
/**
 * Contains response data for the getOneConnection operation.
 */
export declare type GetOneConnectionResponse = Connection & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: Connection;
    };
};
/**
 * Contains response data for the updateConnection operation.
 */
export declare type UpdateConnectionResponse = {
    /**
     * The parsed response body.
     */
    body: any;
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: any;
    };
};
/**
 * Contains response data for the getConnectionVersions operation.
 */
export declare type GetConnectionVersionsResponse = Array<Connection> & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: Connection[];
    };
};
/**
 * Contains response data for the getAllFlows operation.
 */
export declare type GetAllFlowsResponse = Array<Flow> & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: Flow[];
    };
};
/**
 * Contains response data for the createFlow operation.
 */
export declare type CreateFlowResponse = {
    /**
     * The parsed response body.
     */
    body: any;
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: any;
    };
};
/**
 * Contains response data for the getOneFlow operation.
 */
export declare type GetOneFlowResponse = Flow & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: Flow;
    };
};
/**
 * Contains response data for the updateFlow operation.
 */
export declare type UpdateFlowResponse = {
    /**
     * The parsed response body.
     */
    body: any;
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: any;
    };
};
/**
 * Contains response data for the getFlowVersions operation.
 */
export declare type GetFlowVersionsResponse = Array<Flow> & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: Flow[];
    };
};
/**
 * Contains response data for the getJobMapping operation.
 */
export declare type GetJobMappingResponse = Mapping & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: Mapping;
    };
};
/**
 * Contains response data for the setJobStatusForGoBetween operation.
 */
export declare type SetJobStatusForGoBetweenResponse = {
    /**
     * The response body properties.
     */
    [propertyName: string]: string[];
} & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: {
            [propertyName: string]: string[];
        };
    };
};
/**
 * Contains response data for the setRealTimeState operation.
 */
export declare type SetRealTimeStateResponse = {
    /**
     * The response body properties.
     */
    [propertyName: string]: string[];
} & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: {
            [propertyName: string]: string[];
        };
    };
};
/**
 * Contains response data for the getAllJobs operation.
 */
export declare type GetAllJobsResponse = Array<Job> & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: Job[];
    };
};
/**
 * Contains response data for the createJob operation.
 */
export declare type CreateJobResponse = {
    /**
     * The parsed response body.
     */
    body: any;
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: any;
    };
};
/**
 * Contains response data for the getPagedStatusesForJob operation.
 */
export declare type GetPagedStatusesForJobResponse = PagedResultOfJobStatus & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: PagedResultOfJobStatus;
    };
};
/**
 * Contains response data for the eventsPlaceholderForJob operation.
 */
export declare type EventsPlaceholderForJobResponse = DataflowEvent & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: DataflowEvent;
    };
};
/**
 * Contains response data for the getOneJob operation.
 */
export declare type GetOneJobResponse = Job & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: Job;
    };
};
/**
 * Contains response data for the updateJob operation.
 */
export declare type UpdateJobResponse = {
    /**
     * The parsed response body.
     */
    body: any;
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: any;
    };
};
/**
 * Contains response data for the getJobVersions operation.
 */
export declare type GetJobVersionsResponse = Array<Job> & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: Job[];
    };
};
/**
 * Contains response data for the getAllSchemaProfiles operation.
 */
export declare type GetAllSchemaProfilesResponse = Array<SchemaProfile> & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: SchemaProfile[];
    };
};
/**
 * Contains response data for the createSchemaProfile operation.
 */
export declare type CreateSchemaProfileResponse = {
    /**
     * The parsed response body.
     */
    body: any;
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: any;
    };
};
/**
 * Contains response data for the getOneSchemaProfile operation.
 */
export declare type GetOneSchemaProfileResponse = SchemaProfile & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: SchemaProfile;
    };
};
/**
 * Contains response data for the updateSchemaProfile operation.
 */
export declare type UpdateSchemaProfileResponse = {
    /**
     * The parsed response body.
     */
    body: any;
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: any;
    };
};
/**
 * Contains response data for the getSchemaProfileVersions operation.
 */
export declare type GetSchemaProfileVersionsResponse = Array<SchemaProfile> & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: SchemaProfile[];
    };
};
/**
 * Contains response data for the getAllSchemas operation.
 */
export declare type GetAllSchemasResponse = Array<Schema> & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: Schema[];
    };
};
/**
 * Contains response data for the createSchema operation.
 */
export declare type CreateSchemaResponse = {
    /**
     * The parsed response body.
     */
    body: any;
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: any;
    };
};
/**
 * Contains response data for the getOneSchema operation.
 */
export declare type GetOneSchemaResponse = Schema & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: Schema;
    };
};
/**
 * Contains response data for the updateSchema operation.
 */
export declare type UpdateSchemaResponse = {
    /**
     * The parsed response body.
     */
    body: any;
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: any;
    };
};
/**
 * Contains response data for the getSchemaVersions operation.
 */
export declare type GetSchemaVersionsResponse = Array<Schema> & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: Schema[];
    };
};
/**
 * Contains response data for the getAllShapes operation.
 */
export declare type GetAllShapesResponse = Array<Shape> & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: Shape[];
    };
};
/**
 * Contains response data for the createShape operation.
 */
export declare type CreateShapeResponse = {
    /**
     * The parsed response body.
     */
    body: any;
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: any;
    };
};
/**
 * Contains response data for the getOneShape operation.
 */
export declare type GetOneShapeResponse = Shape & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: Shape;
    };
};
/**
 * Contains response data for the updateShape operation.
 */
export declare type UpdateShapeResponse = {
    /**
     * The parsed response body.
     */
    body: any;
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: any;
    };
};
/**
 * Contains response data for the getShapeVersions operation.
 */
export declare type GetShapeVersionsResponse = Array<Shape> & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: Shape[];
    };
};
//# sourceMappingURL=index.d.ts.map