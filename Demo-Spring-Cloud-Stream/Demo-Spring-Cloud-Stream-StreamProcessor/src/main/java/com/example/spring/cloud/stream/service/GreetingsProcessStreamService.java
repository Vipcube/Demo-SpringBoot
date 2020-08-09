package com.example.spring.cloud.stream.service;

/**
 * The binging processor pattern by spring component pattern.
 *
 * @author Brad Chen
 *
 */
//@Slf4j
//@Service
//@EnableBinding( { KafkaStreamsProcessor.class } )
public class GreetingsProcessStreamService {
	//@StreamListener( Processor.INPUT )
	//@SendTo( Processor.OUTPUT )
	//public KStream<?, Greetings> process( KStream<?, Greetings> input ) {
	//	return input.map( (key, value) ->
	//			KeyValue.pair( null,
	//					Greetings.builder()
	//							.timestamp( value.getTimestamp() )
	//							.message( value.getMessage() + " Processed" )
	//							.build()
	//			)
	//	);
	//}
}
