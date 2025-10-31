// swift-tools-version:5.3
import PackageDescription

let package = Package(
   name: "{{REPOSITORY_NAME}}",
   platforms: [
     .iOS(.v14),
     .macOS(.v11),
   ],
   products: [
      .library(name: "{{REPOSITORY_NAME}}", targets: ["{{XCFRAMEWORK_NAME}}"])
   ],
   targets: [
      .binaryTarget(
         name: "{{XCFRAMEWORK_NAME}}",
         url: "{{XCFRAMEWORK_URL}}",
         checksum: "{{XCFRAMEWORK_CHECKSUM}}")
   ]
)