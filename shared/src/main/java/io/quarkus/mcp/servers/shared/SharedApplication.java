package io.quarkus.mcp.servers.shared;

import java.util.List;
import java.util.function.Function;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class SharedApplication {

    public static void main(String[] args) {
        main(args, (remainingArgs) -> null);
    }

    public static void main(String[] args, Function<List<String>, Void> onArgsProcessed) {
       onArgsProcessed.apply(McpCliConfigSource.setupConfigSource(args));

        Quarkus.run(null, 
            (exitCode, exception) -> {
                if(exception != null) {
                    exception.printStackTrace();
                } 
                System.exit(exitCode);
                }, 
                args);
    }
}
