SCRIPT_PATH=$(dirname $(readlink -f $0))
QUERY=$1
R="R${QUERY}"



${SCRIPT_PATH}/dbtoaster-backend/ddbtoaster/release/bin/dbtoaster -l scala -o "${R}" "${SCRIPT_PATH}/queries/${QUERY}.sql"


mv "${SCRIPT_PATH}/${R}.scala" "src/main/scala/ddbt/gen/"
cp "${SCRIPT_PATH}/build.sbt.template" "${SCRIPT_PATH}/build.sbt"

sed -i "s/name/name := \"${R}\"/" $SCRIPT_PATH/build.sbt
sed -i "s/mainClass/mainClass in Compile := Some(\"ddbt.gen.${R}\")/" $SCRIPT_PATH/build.sbt
sed -i "s/assemblyOutputPath/assemblyOutputPath in assembly := file(\"target\/${R}.jar\")/" $SCRIPT_PATH/build.sbt

rm -rf "${SCRIPT_PATH}/target"
rm -rf "${SCRIPT_PATH}/project/target"
rm -rf "${SCRIPT_PATH}/project/project"
cd ${SCRIPT_PATH}

#sbt clean 
sbt compile
sbt assembly
java -jar "target/${R}.jar"
#timeout -s SIGKILL 14400s tasket -c 32 java  -Xms128g -Xmx128g -jar "target/${R}.jar"